import io
import os

# Based on https://raw.githubusercontent.com/cheran-senthil/PyRival/master/pyrival/data_structures/SortedList.py
# Modified to do range sum queries
class SortedListWithSum:
    def __init__(self, iterable=[], _load=200):
        """Initialize sorted list instance."""
        values = sorted(iterable)
        self._len = _len = len(values)
        self._sum = sum(values)
        self._load = _load
        self._lists = _lists = [values[i : i + _load] for i in range(0, _len, _load)]
        self._mins = [_list[0] for _list in _lists]
        self._list_lens = [len(_list) for _list in _lists]
        self._fen_tree = []
        self._list_sums = [sum(_list) for _list in _lists]
        self._fen_tree_sum = []
        self._rebuild = True

    def _fen_build(self):
        """Build a fenwick tree instance."""
        self._fen_tree[:] = self._list_lens
        _fen_tree = self._fen_tree
        for i in range(len(_fen_tree)):
            if i | i + 1 < len(_fen_tree):
                _fen_tree[i | i + 1] += _fen_tree[i]

        self._fen_tree_sum[:] = self._list_sums
        _fen_tree_sum = self._fen_tree_sum
        for i in range(len(_fen_tree_sum)):
            if i | i + 1 < len(_fen_tree_sum):
                _fen_tree_sum[i | i + 1] += _fen_tree_sum[i]

        self._rebuild = False

    def _fen_update(self, index, value):
        """Update `fen_tree[index] += value`."""
        if not self._rebuild:
            _fen_tree = self._fen_tree
            while index < len(_fen_tree):
                _fen_tree[index] += value
                index |= index + 1

    def _fen_update_sum(self, index, value):
        """Update `fen_tree2[index] += value`."""
        if not self._rebuild:
            _fen_tree = self._fen_tree_sum
            while index < len(_fen_tree):
                _fen_tree[index] += value
                index |= index + 1

    def _fen_query(self, end):
        """Return `sum(_fen_tree[:end])`."""
        if self._rebuild:
            self._fen_build()

        _fen_tree = self._fen_tree
        x = 0
        while end:
            x += _fen_tree[end - 1]
            end &= end - 1
        return x

    def _fen_query_sum(self, end):
        """Return `sum(_fen_tree_sum[:end])`."""
        if self._rebuild:
            self._fen_build()

        _fen_tree = self._fen_tree_sum
        x = 0
        while end:
            x += _fen_tree[end - 1]
            end &= end - 1
        return x

    def _fen_findkth(self, k):
        """Return a pair of (the largest `idx` such that `sum(_fen_tree[:idx]) <= k`, `k - sum(_fen_tree[:idx])`)."""
        _list_lens = self._list_lens
        if k < _list_lens[0]:
            return 0, k
        if k >= self._len - _list_lens[-1]:
            return len(_list_lens) - 1, k + _list_lens[-1] - self._len
        if self._rebuild:
            self._fen_build()

        _fen_tree = self._fen_tree
        idx = -1
        for d in reversed(range(len(_fen_tree).bit_length())):
            right_idx = idx + (1 << d)
            if right_idx < len(_fen_tree) and k >= _fen_tree[right_idx]:
                idx = right_idx
                k -= _fen_tree[idx]
        return idx + 1, k

    def _delete(self, pos, idx):
        """Delete value at the given `(pos, idx)`."""
        _lists = self._lists
        _mins = self._mins
        _list_lens = self._list_lens
        _list_sums = self._list_sums

        value = _lists[pos][idx]
        self._len -= 1
        self._sum -= value
        self._fen_update(pos, -1)
        self._fen_update_sum(pos, -value)
        del _lists[pos][idx]
        _list_lens[pos] -= 1
        _list_sums[pos] -= value

        if _list_lens[pos]:
            _mins[pos] = _lists[pos][0]
        else:
            del _lists[pos]
            del _list_lens[pos]
            del _list_sums[pos]
            del _mins[pos]
            self._rebuild = True

    def _loc_left(self, value):
        """Return an index pair that corresponds to the first position of `value` in the sorted list."""
        if not self._len:
            return 0, 0

        _lists = self._lists
        _mins = self._mins

        lo, pos = -1, len(_lists) - 1
        while lo + 1 < pos:
            mi = (lo + pos) >> 1
            if value <= _mins[mi]:
                pos = mi
            else:
                lo = mi

        if pos and value <= _lists[pos - 1][-1]:
            pos -= 1

        _list = _lists[pos]
        lo, idx = -1, len(_list)
        while lo + 1 < idx:
            mi = (lo + idx) >> 1
            if value <= _list[mi]:
                idx = mi
            else:
                lo = mi

        return pos, idx

    def _loc_right(self, value):
        """Return an index pair that corresponds to the last position of `value` in the sorted list."""
        if not self._len:
            return 0, 0

        _lists = self._lists
        _mins = self._mins

        pos, hi = 0, len(_lists)
        while pos + 1 < hi:
            mi = (pos + hi) >> 1
            if value < _mins[mi]:
                hi = mi
            else:
                pos = mi

        _list = _lists[pos]
        lo, idx = -1, len(_list)
        while lo + 1 < idx:
            mi = (lo + idx) >> 1
            if value < _list[mi]:
                idx = mi
            else:
                lo = mi

        return pos, idx

    def add(self, value):
        """Add `value` to sorted list."""
        _load = self._load
        _lists = self._lists
        _mins = self._mins
        _list_lens = self._list_lens
        _list_sums = self._list_sums

        self._len += 1
        self._sum += value
        if _lists:
            pos, idx = self._loc_right(value)
            self._fen_update(pos, 1)
            self._fen_update_sum(pos, value)
            _list = _lists[pos]
            _list.insert(idx, value)
            _list_lens[pos] += 1
            _list_sums[pos] += value
            _mins[pos] = _list[0]
            if _load + _load < len(_list):
                back = _list[_load:]
                old_len = _list_lens[pos]
                old_sum = _list_sums[pos]
                new_len_front = _load
                new_len_back = old_len - new_len_front
                new_sum_back = sum(back)
                new_sum_front = old_sum - new_sum_back
                _lists.insert(pos + 1, back)
                _list_lens.insert(pos + 1, new_len_back)
                _list_sums.insert(pos + 1, new_sum_back)
                _mins.insert(pos + 1, _list[_load])
                _list_lens[pos] = new_len_front
                _list_sums[pos] = new_sum_front
                del _list[_load:]
                # assert len(_lists[pos]) == _list_lens[pos]
                # assert len(_lists[pos + 1]) == _list_lens[pos + 1]
                # assert sum(_lists[pos]) == _list_sums[pos]
                # assert sum(_lists[pos + 1]) == _list_sums[pos + 1]
                self._rebuild = True
        else:
            _lists.append([value])
            _mins.append(value)
            _list_lens.append(1)
            _list_sums.append(value)
            self._rebuild = True

    def discard(self, value):
        """Remove `value` from sorted list if it is a member."""
        _lists = self._lists
        if _lists:
            pos, idx = self._loc_right(value)
            if idx and _lists[pos][idx - 1] == value:
                self._delete(pos, idx - 1)

    def remove(self, value):
        """Remove `value` from sorted list; `value` must be a member."""
        _len = self._len
        self.discard(value)
        if _len == self._len:
            raise ValueError("{0!r} not in list".format(value))

    def pop(self, index=-1):
        """Remove and return value at `index` in sorted list."""
        pos, idx = self._fen_findkth(self._len + index if index < 0 else index)
        value = self._lists[pos][idx]
        self._delete(pos, idx)
        return value

    def bisect_left(self, value):
        """Return the first index to insert `value` in the sorted list."""
        pos, idx = self._loc_left(value)
        return self._fen_query(pos) + idx

    def bisect_right(self, value):
        """Return the last index to insert `value` in the sorted list."""
        pos, idx = self._loc_right(value)
        return self._fen_query(pos) + idx

    def count(self, value):
        """Return number of occurrences of `value` in the sorted list."""
        return self.bisect_right(value) - self.bisect_left(value)

    def __len__(self):
        """Return the size of the sorted list."""
        return self._len

    def __getitem__(self, index):
        """Lookup value at `index` in sorted list."""
        pos, idx = self._fen_findkth(self._len + index if index < 0 else index)
        return self._lists[pos][idx]

    def __delitem__(self, index):
        """Remove value at `index` from sorted list."""
        pos, idx = self._fen_findkth(self._len + index if index < 0 else index)
        self._delete(pos, idx)

    def __contains__(self, value):
        """Return true if `value` is an element of the sorted list."""
        _lists = self._lists
        if _lists:
            pos, idx = self._loc_left(value)
            return idx < len(_lists[pos]) and _lists[pos][idx] == value
        return False

    def __iter__(self):
        """Return an iterator over the sorted list."""
        return (value for _list in self._lists for value in _list)

    def __reversed__(self):
        """Return a reverse iterator over the sorted list."""
        return (value for _list in reversed(self._lists) for value in reversed(_list))

    def __repr__(self):
        """Return string representation of sorted list."""
        return "SortedList({0})".format(list(self))

    def query(self, i, j):
        if i == j:
            return 0
        pos1, idx1 = self._fen_findkth(self._len + i if i < 0 else i)
        pos2, idx2 = self._fen_findkth(self._len + j if j < 0 else j)
        return (
            sum(self._lists[pos1][idx1:])
            + (self._fen_query_sum(pos2) - self._fen_query_sum(pos1 + 1))
            + sum(self._lists[pos2][:idx2])
        )

    def sum(self):
        return self._sum


def solve(N, M, K, books):
    A = []
    B = []
    common = []
    padding = SortedListWithSum()
    for i, (t, a, b) in enumerate(books):
        if a and b:
            common.append(t)
        elif a:
            A.append(t)
        elif b:
            B.append(t)
        else:
            padding.add(t)

    A.sort()
    B.sort()
    common.sort()

    prefA = [0]
    for t in A:
        prefA.append(prefA[-1] + t)
    prefB = [0]
    for t in B:
        prefB.append(prefB[-1] + t)
    prefC = [0]
    for t in common:
        prefC.append(prefC[-1] + t)

    # Check allowable number of common books
    cMin = max(0, K - len(A), K - len(B), 2 * K - M)
    cMax = min(K, len(common))
    if cMin > cMax:
        return -1

    # Want to contain every book in: common[:c], B[: K - c], A[: K - c], padding
    # starting with c = cMin
    for i in range(cMin, len(common)):
        padding.add(common[i])
    for i in range(K - cMin, len(A)):
        padding.add(A[i])
    for i in range(K - cMin, len(B)):
        padding.add(B[i])

    best = (float("inf"),)
    for c in range(cMin, cMax + 1):
        # Take c common books to satisfy both
        # Need K - c more from A and B each
        assert 0 <= c <= len(common)
        assert 0 <= K - c <= len(A)
        assert 0 <= K - c <= len(B)
        # Pad this up to make M books exactly
        pad = M - c - (K - c) * 2
        assert 0 <= pad <= N

        cost = prefC[c] + prefB[K - c] + prefA[K - c] + padding.query(0, min(pad, len(padding)))
        best = min(best, (cost, c))

        # On next iteration, A[K-c-1] and B[K-c-1] won't be needed
        # Move them to padding
        if 0 <= K - c - 1 < len(A):
            x = A[K - c - 1]
            padding.add(x)
        if 0 <= K - c - 1 < len(B):
            x = B[K - c - 1]
            padding.add(x)
        # On next iteration, common[c] will be needed
        if c < len(common):
            x = common[c]
            padding.remove(x)

    assert best[0] != float("inf")

    # Reconstruct
    needC = best[1]
    needA = K - needC
    needB = K - needC
    needPad = M - needC - needB - needA

    check = 0
    ans = []
    for i, (t, a, b) in sorted(enumerate(books), key=lambda ix: ix[1][0]):
        if a and b:
            if needC:
                needC -= 1
                ans.append(str(i + 1))
                check += t
                continue
        if a:
            if needA:
                needA -= 1
                ans.append(str(i + 1))
                check += t
                continue
        if b:
            if needB:
                needB -= 1
                ans.append(str(i + 1))
                check += t
                continue
        if needPad:
            needPad -= 1
            ans.append(str(i + 1))
            check += t
    assert len(ans) == M
    assert check == best[0]

    return str(best[0]) + "\n" + " ".join(x for x in ans)


if False:
    import random

    random.seed(0)
    N = 2 * 10 ** 2
    for i in range(1000):
        books = [
            [random.randint(1, 20), random.randint(0, 1), random.randint(0, 1)]
            for i in range(N)
        ]
        M = min(N, random.randint(1, 100))
        K = min(M, random.randint(1, 100))
        # print(N, M, K, books)
        solve(N, M, K, books)

if __name__ == "__main__":
    input = io.BytesIO(os.read(0, os.fstat(0).st_size)).readline

    N, M, K = [int(x) for x in input().split()]
    books = [[int(x) for x in input().split()] for i in range(N)]
    ans = solve(N, M, K, books)
    print(ans)
