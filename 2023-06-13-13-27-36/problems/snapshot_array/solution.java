class SnapshotArray {
    private List<TreeMap<Integer, Integer>> snapshots;
    private int snapId;

    public SnapshotArray(int length) {
        snapshots = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            snapshots.add(new TreeMap<>());
        }
        snapId = 0;
    }

    public void set(int index, int val) {
        TreeMap<Integer, Integer> snapMap = snapshots.get(index);
        snapMap.put(snapId, val);
    }

    public int snap() {
        return snapId++;
    }

    public int get(int index, int snapId) {
        TreeMap<Integer, Integer> snapMap = snapshots.get(index);
        Integer value = snapMap.floorEntry(snapId) != null 
        ? snapMap.floorEntry(snapId).getValue() 
        : null;
        return value != null ? value : 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */