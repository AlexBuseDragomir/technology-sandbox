#!/bin/bash

if [ $# -ne 2 ]; then
    echo "Usage: $0 <source_directory> <target_directory>"
    exit 1
fi

# Convert to absolute paths
# This fixes the nesting issue completely.
SOURCE_DIR=$(cd "$1" && pwd)
TARGET_DIR=$(cd "$2" && pwd)

# Check for rsync
if ! command -v rsync > /dev/null 2>&1; then
    echo "Error: rsync is not installed."
    exit 2
fi

CURRENT_DATE=$(date +%Y-%m-%d)

# These are now guaranteed to be siblings because TARGET_DIR is absolute
CURRENT_BACKUP="$TARGET_DIR/current"
INCREMENTAL_DIR="$TARGET_DIR/$CURRENT_DATE"
LOG_FILE="$TARGET_DIR/backup_$CURRENT_DATE.log"

mkdir -p "$TARGET_DIR"

# Run rsync
# Note: We use "$SOURCE_DIR/" with the trailing slash to copy contents
rsync -avb --backup-dir="$INCREMENTAL_DIR" --delete "$SOURCE_DIR/" "$CURRENT_BACKUP" >> "$LOG_FILE" 2>&1

echo "Backup Done. Logs at $LOG_FILE"