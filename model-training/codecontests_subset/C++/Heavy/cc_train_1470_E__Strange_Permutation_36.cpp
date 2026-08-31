#include <cassert>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <algorithm>
#include <iostream>
#include <set>
#include <map>
#include <vector>
#include <string>

#include <cmath>
#include <queue>
#include <stack>

#include <unordered_set>
#include <unordered_map>
#include <array>

using namespace std;

#define LL long long

inline int read() {
    int x = 0, f = 1;
    char c = getchar();
    while (c < '0' || c > '9') {
        if (c == '-') {
            f = -1;
        }
        c = getchar();
    }
    while (c >= '0' && c <= '9') {
        x = x * 10 + c - '0';
        c = getchar();
    }
    return x * f;
}

inline void write(int x) {
    static int sta[35];
    int top = 0;
    do {
        sta[top++] = x % 10, x /= 10;
    } while (x);
    while (top) putchar(sta[--top] + 48); 
}

inline void writeln(int x) {
	if (x < 0) {
		putchar('-'); x = -x;
	}
    static int sta[35];
    int top = 0;
    do {
        sta[top++] = x % 10, x /= 10;
    } while (x);
    while (top) putchar(sta[--top] + 48); 
	putchar('\n');
}

inline LL readll() {
    LL x = 0, f = 1;
    char c = getchar();
    while (c < '0' || c > '9') {
        if (c == '-') {
            f = -1;
        }
        c = getchar();
    }
    while (c >= '0' && c <= '9') {
        x = x * 10 + c - '0';
        c = getchar();
    }
    return x * f;
}

inline void writell(LL x) {
	if (x < 0) {
		putchar('-'); x = -x;
	}
    static LL sta[35];
    int top = 0;
    do {
        sta[top++] = x % 10, x /= 10;
    } while (x);
    while (top) putchar(sta[--top] + 48); 
}

inline void writellln(LL x) {
	if (x < 0) {
		putchar('-'); x = -x;
	}
    static LL sta[35];
    int top = 0;
    do {
        sta[top++] = x % 10, x /= 10;
    } while (x);
    while (top) putchar(sta[--top] + 48); 
	putchar('\n');
}

const int hashMod = 999983;

template<class TYPENAME>
class HashNode {
public:
    TYPENAME val;
    int key, next;
    HashNode(TYPENAME _val, int _key, int _next): val(_val), key(_key), next(_next) {}
    bool isNull() {
        return key == -1;
    }
};

template<class TYPENAME>
class Hash {
public:
    vector<HashNode<TYPENAME> > nodes;
    vector<int> d;
    int nodeN;
    Hash() {
        nodeN = 0; 
        d = vector<int>(hashMod, -1);
    }
    void push(int key, TYPENAME val) {
        nodes.push_back(HashNode<TYPENAME>(val, key, d[key]));
        d[key] = nodeN++;
    }
    HashNode<TYPENAME> find(int key, TYPENAME val) {
        for (int p = d[key]; p != -1; p = nodes[p].next) {
            if (nodes[p].val == val) {
                return nodes[p];
            }
        }
        return HashNode<TYPENAME>(val, -1, -1);
    }
};

int n, c, q;
vector<int> ii;
vector<LL> jj;
vector<int> p;
vector<vector<LL> > ways, wayC;

LL permContained(int l, int r, int cc) {
    if (l == -1) {
        return 1; // result for {-1, -1}
    }
    // otherwise, we can rotate (r, n)
    // we have n - r - 1 to rotate, and cc - (r - l) coins
    return ways[n - r - 1][cc - (r - l)];
}

// we can discretize all the queries, so we have an index for each query
// for each layer, we first save all the queries into boxes
// and take them out

bool pSmaller(const pair<int, int> &a, const pair<int, int> &b) {
    return p[a.second] < p[b.second];
}
bool pGreater(const pair<int, int> &a, const pair<int, int> &b) {
    return p[a.second] > p[b.second];
}

class Query {
public:
    int ii, idx;
    LL jj;
    Query(int _idx, int _ii, LL _jj): idx(_idx), ii(_ii), jj(_jj) {}
    void print() {
        printf("Query(idx = %d, ii = %d, jj = %lld) ", idx, ii, jj);
    }
};

bool cmpQuery(const Query &a, const Query &b) {
    return a.jj < b.jj;
}
void solve() {
    n = read(); c = read(); q = read();
    // printf("task: n = %d. c = %d, q = %d\n", n, c, q);
    p = vector<int>(n);
    for (int i = 0; i < n; ++i) {
        p[i] = read();
    }
    ii = vector<int>(q);
    jj = vector<LL>(q);
    for (int i = 0; i < q; ++i) {
        ii[i] = read() - 1; jj[i] = readll() - 1;
        // cout << ii[i] << ' ' << jj[i] << endl;
    }

    // for (int i = 0; i < q; ++i) {
    //     // ii[i] = read() - 1; jj[i] = readll() - 1;
    //     cout << ii[i] << ' ' << jj[i] << endl;
    // }

    wayC = vector<vector<LL> >(n);
    for (int i = 0; i < n; ++i) {
        wayC[i] = vector<LL>(c + 1, 0);
        wayC[i][0] = 1;
    }

    // wayC[n][c] = C(n, c)
    for (int i = 0; i < n; ++i) {
        for (int j = 1; j <= c; ++j) {
            // consider C(i, j)
            if (i < j) {
                wayC[i][j] = 0;
            } else {
                wayC[i][j] = wayC[i - 1][j] + wayC[i - 1][j - 1];
            }
        }
    }

    // cout << "finish wayC" << endl;
    // for (int i = 0; i < q; ++i) {
    //     // ii[i] = read() - 1; jj[i] = readll() - 1;
    //     cout << ii[i] << ' ' << jj[i] << endl;
    // }
    
    ways = vector<vector<LL> >(n + 1);
    for (int i = 0; i <= n; ++i) {
        ways[i] = vector<LL>(c + 1, 1);
    }
    // ways[n][c] = C(n - 1, 0) + C(n - 1, 1) + ... + C(n - 1, c)
    // ways[n][c] = ways[n][c - 1] + wayC[n - 1][c] (n > 0)
    for (int i = 1; i <= n; ++i) {
        ways[i][0] = wayC[i - 1][0];
        for (int j = 1; j <= c; ++j) {
            ways[i][j] = ways[i][j - 1] + wayC[i - 1][j];
            // printf("ways(len = %d, c = %d) = %lld\n", i, j, ways[i][j]);
        }
    }

    // cout << "finish ways" << endl;

    // for (int i = 0; i < q; ++i) {
    //     // ii[i] = read() - 1; jj[i] = readll() - 1;
    //     cout << ii[i] << ' ' << jj[i] << endl;
    // }

    // now ways[len][c] = ways(n, c)

    // we should build a deque for each 0 .. c, contains
    // the [l, r] as the leftmost rotation(not over c)
    // and sorted by the lex order. Our queries are all on layer c(we can use at most c coins)
    // we sort all the jj, and scan the deque, every time we find an [l, r] so that jj is behind this
    // we know that [0 .. r] has been decided for this jj query. if ii <= r, we can return the query result
    // otherwise we want to decide the remaining part jj - ord([l, r]) = jj', with coins c - r + l, 
    // and start from r + 1
    // for each c, we can decide p[l] "permutations before using [l, r] started at l" for each l in [0, n)
    // so the query becomes another query (c - r + l, jj' + p[r + 1], ii) on layer c - r + l
    // finally we have all queryies on layer 0, so there is only one state for queries
    // queries down to here must asks something hard to decide, and here we must have jj = 1
    // then we just return i-th

    // first to make deques for each c' = [0 .. c]

    vector<deque<pair<int, int> > > dq(c + 1);
    for (int cc = 0; cc <= c; ++cc) {
        // dq[cc].push_back({-1, -1}); // no change
        dq[cc].push_back({n - 1, n - 1});
        for (int i = n - 1; i >= 0; --i) {
            vector<pair<int, int> > lft, rgt;
            for (int j = i + 1; j <= i + cc && j < n; ++j) {
                // we have rotations [i, j]
                // current deque has all permutations with i-th = p[i]
                // so [i, j] is with i-th = p[j]
                // we should divide it into two parts: p[j] < p[i] && p[j] > p[i]
                // for p[j] < p[i], we insert it at front, from the order p[j] large to small
                // for p[j] > p[i], we insert it at back, from small to large
                // printf("p[j = %d] = %d, p[i = %d] = %d\n", j, p[j], i, p[i]);
                if (p[j] < p[i]) {
                    lft.push_back({i, j});
                } else {
                    rgt.push_back({i, j});
                }
            }
            sort(lft.begin(), lft.end(), pGreater);
            sort(rgt.begin(), rgt.end(), pSmaller);
            for (int i = 0; i < lft.size(); ++i) {
                dq[cc].push_front(lft[i]);
            }
            for (int i = 0; i < rgt.size(); ++i) {
                dq[cc].push_back(rgt[i]);
            }
        }

        // cout << "c = " << cc << endl;
        // for (auto pr: dq[cc]) {
        //     printf("(%d, %d) ", pr.first, pr.second);
        // }
        // putchar('\n');
    }

    // cout << "finish creating deques" << endl;

    // int mc = 0;
    // vector<int> queryIdx = discretize(jj, mc);
    // vector<LL> ts(mc + 1, 0);
    // for (int i = 0; i < q; ++i) {
    //     ts[queryIdx[i]] = jj[i];
    // }
    // vector<vector<vector<Query> > > ids(c + 1);
    // for (int i = 0; i <= c; ++i) {
    //     ids[i] = vector<vector<Query> >(mc + 1);
    // }
    // for (int i = 0; i < q; ++i) {
    //     ids[c][queryIdx[i]].push_back(Query(i, ii[i], queryIdx[i], jj[i]));
    // }

    vector<int> ans(q, -1);
    // for (int i = 0; i < q; ++i) {
    //     ans[i] = -1;
    // }
    // for (int i = 0; i < q; ++i) {
    //     cout << ans[i] << ' ';
    // }
    // cout << endl;

    vector<vector<Query> > que(c + 1);
    for (int i = 0; i < q; ++i) {
        que[c].push_back(Query(i, ii[i], jj[i]));
        // que[c].back().print();
    }

    vector<vector<LL> > pp(c + 1);
    // pp[cc][l]: the permutations before the first [l, r] started at l(l in [0, n - 1))
    for (int cc = 0; cc <= c; ++cc) {
        pp[cc] = vector<LL>(n, -1);
        LL perms = 0;
        int ll, rr;
        for (pair<int, int> pr: dq[cc]) {
            ll = pr.first; rr = pr.second;
            if (ll == -1) {
                continue;
            }
            if (pp[cc][ll] == -1) {
                pp[cc][ll] = perms;
                // printf("pp[c = %d][l = %d] = %lld, from (l = %d, r = %d)\n", cc, ll, pp[cc][ll], ll, rr);
            }
            perms += permContained(ll, rr, cc);
        }
        // pp[cc][n - 1] = perms - 1;
        for (int i = n - 2; i >= 0; --i) {
            pp[cc][i] = min(pp[cc][i], pp[cc][i + 1]);
        }
        for (int i = 0; i < n; ++i) {
            // printf("pp[c = %d][l = %d] = %lld\n", cc, i, pp[cc][i]);
        }
        // how to deal with -1, -1? it means no rotation at all
        // and contains exactly 1 permutation p0 ... p_{n - 1}
    }

    // cout << "finish calculating pp's" << endl;

    for (int cc = c; cc >= 0; --cc) {
        // work on layer cc
        if (que[cc].size() == 0) {
            continue;
        }
        sort(que[cc].begin(), que[cc].end(), cmpQuery);
        // now we have queries saved in que[cc]
        // and sorted by order of jj

        // for [l, r] on layer cc, the undecided part is (r, n), len = n - r - 1
        // so it contains ways[n - r - 1][cc - (r - l)]
        // we go from the beginning of dq[cc], and use a pointer in que[cc] for current 

        // when we want to insert a new query c', jj', ii, we just do que[c'].push_back(Query(idx, ii, jj'))
        // TODO: !!!!!
        int qcur = 0;
        LL currPerm = 0;
        // cout << "coin " << cc << ": ";
        // for (int i = 0; i < que[cc].size(); ++i) {
        //     // printf("Query(idx = %d, ii = %d, jj = %lld) ", que[cc][i].idx, que[cc][i].ii, que[cc][i].jj);
        //     que[cc][i].print();
        // }
        // cout << endl;

        // for (int i = 0; i < q; ++i) {
        //     cout << ans[i] << ' ';
        // }
        // cout << endl;

        for (pair<int, int> pr: dq[cc]) {
            int ll = pr.first, rr = pr.second;
            // printf("(%d, %d) ", ll, rr);
            // printf("l = %d, r = %d, cc = %d, currPerm = %lld\n", ll, rr, cc, currPerm);
            LL newPerm = permContained(ll, rr, cc);
            // printf("new perm = %lld\n", newPerm);
            while (qcur < que[cc].size() && que[cc][qcur].jj < currPerm + newPerm) {
                int cii = que[cc][qcur].ii;
                LL cjj = que[cc][qcur].jj;
                int cidx = que[cc][qcur].idx;
                // printf("qcur = %d: idx = %d, ii = %d, jj = %lld\n", qcur, cidx, cii, cjj);
                if (ll == -1 || cii < ll) {
                    // cout << "quit1" << endl;
                    ans[cidx] = p[cii];
                    ++qcur; continue;
                }
                if (cii >= ll && cii <= rr) {
                    // cout << "quit2" << endl;
                    ans[cidx] = p[rr - (cii - ll)];
                    ++qcur; continue;
                }
                // otherwise, it is not determined
                // we should insert it into cc - (rr - ll)
                int nc = cc - (rr - ll);
                // what is the rank of the permutation in nc?
                // all [0, r] fixed, so we need to find the (que[cc][qucr].jj - currPerm)-th 
                // in dq[cc], after pp[cc][r + 1]
                if (rr >= n - 1) {
                    // cout << "quit-1" << endl;
                    ans[cidx] = -1;
                    ++qcur; continue;
                }
                // otherwise, we should insert it to layer nc
                que[nc].push_back(Query(cidx, cii, pp[nc][rr + 1] + cjj - currPerm));
                ++qcur;
                // cout << "quit0" << endl;
            }
            currPerm += newPerm;
        }
    }

    for (int i = 0; i < q; ++i) {
        writeln(ans[i]);
    }
}

int main() {
	// std::ios::sync_with_stdio(false);
    // std::cin.tie(0);
    int t = read();
    for (int i = 0; i < t; ++i) {
        solve();
    }
	return 0;
}