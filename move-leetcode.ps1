# move-leetcode.ps1
$repoPath = "C:\Users\anilk\OneDrive\Documents\GitHub\LeetCodeSubmissions"
$timestamp = Get-Date -Format "yyyy-MM-dd-HH-mm-ss"
$targetRoot = Join-Path $repoPath $timestamp

# Find all new problem folders under "problems"
$problemsPath = Join-Path $repoPath "problems"
$problemFolders = Get-ChildItem -Path $problemsPath -Directory

foreach ($folder in $problemFolders) {
    $slug = $folder.Name
    $dest = Join-Path $targetRoot "problems\$slug"

    # Create destination folder
    New-Item -ItemType Directory -Force -Path $dest | Out-Null

    # Move files
    Get-ChildItem -Path $folder.FullName | ForEach-Object {
        Move-Item $_.FullName -Destination $dest -Force
    }
}

# Remove the original "problems" folder entirely
Remove-Item $problemsPath -Recurse -Force

Write-Host "Solutions moved to $targetRoot and original 'problems' folder deleted."
