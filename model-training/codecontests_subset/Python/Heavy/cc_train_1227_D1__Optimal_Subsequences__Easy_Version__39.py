import sys as _sys


def main():
    t = 1
    for i_t in range(t):
        n, = _read_ints()
        a = tuple(_read_ints())
        m, = _read_ints()
        queries = (tuple(_read_ints()) for i_query in range(m))
        result = process_queries(a, queries)
        print(*result, sep='\n')


def _read_line():
    result = _sys.stdin.readline()
    assert result[-1] == "\n"
    return result[:-1]


def _read_ints():
    return map(int, _read_line().split())


def process_queries(sequence, queries):
    sequence = tuple(sequence)
    sorted_sequence = sorted(sequence, reverse=True)
    for k, pos in queries:
        pos -= 1
        k_max_elems = sorted_sequence[:k][::-1]
        seq = sequence
        subseq = []
        while len(subseq) < k:
            for i_next_elem in range(len(k_max_elems)):
                next_elem = k_max_elems[i_next_elem]
                seq_after = seq[seq.index(next_elem)+1:]
                elems_remain = k_max_elems[:i_next_elem] + k_max_elems[i_next_elem+1:]
                if _contains_elems(seq_after, elems_remain):
                    seq = seq_after
                    k_max_elems = elems_remain
                    subseq.append(next_elem)
                    break
        yield subseq[pos]


def _contains_elems(seq, elems):
    seq = sorted(seq)
    subseq = sorted(elems)
    i_seq = 0
    i_subseq = 0
    while i_seq < len(seq) and i_subseq < len(subseq):
        if seq[i_seq] == subseq[i_subseq]:
            i_subseq += 1
        i_seq += 1
    return i_subseq == len(subseq)


if __name__ == '__main__':
    main()
