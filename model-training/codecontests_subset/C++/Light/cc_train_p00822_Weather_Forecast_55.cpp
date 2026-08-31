#include <cstdio>
#include <iostream>
#include <set>
#include <vector>
#include <cstring>
#include <algorithm>
using namespace std;
typedef long long int ll;

struct Elem {
    int pos, day;
    vector<int> sunny;
    bool operator<(const Elem &x) const {
        if(day != x.day) return day < x.day;
        if(pos != x.pos) return pos < x.pos;
        return sunny < x.sunny;
    }
};

// generate binary string (not less than k-digit)
string to_binString(int n, int k) {
    string ret = "";
    while(n) ret += ('0' + (n&1)), n >>= 1;
    while(ret.length() < k) ret += '0';
    // reverse(ret.begin(), ret.end());
    return ret;
}

int N, val[400];
set<Elem> S;

int d[9][4] = {
    // URDL
    {-4, -3, 0, 1},
    {1, 2, 5, 6},
    {4, 5, 8, 9},
    {-1, 0, 3, 4},

    {-8, -7, -4, -3},
    {2, 3, 6, 7},
    {8, 9, 12, 13},
    {-2, -1, 2, 3},

    {0, 1, 4, 5}
};

bool ans = false;
void solve(Elem e) {
    if(!S.count(e)) {
        S.insert(e);
        if(e.day == N) {
            ans = true;
            return;
        }
        if(ans) return;
        for(int k=0; k<9; k++) {
            if(k == 0 && e.pos/4 == 0) continue;
            if(k == 1 && e.pos%4 == 2) continue;
            if(k == 2 && e.pos/4 == 2) continue;
            if(k == 3 && e.pos%4 == 0) continue;

            if(k == 4 && e.pos/4 <  2) continue;
            if(k == 5 && e.pos%4 != 0) continue;
            if(k == 6 && e.pos/4 != 0) continue;
            if(k == 7 && e.pos%4 <  2) continue;
            bool ok = true;
            int nbit = (1 << 16) - 1, npos = e.pos + d[k][0];
            for(int x=0; x<4; x++) {
                int c = d[k][x] + e.pos;
                nbit ^= (1 << c);
            }
            /*
            printf("day = %d, dir = %d, bit = \n", e.day, k);
            for(int i=0; i<4; i++) {
                for(int j=0; j<4; j++) printf("%d", val[e.day]>>(i*4+j)&1);
                printf("  ");
                for(int j=0; j<4; j++) printf("%d", (nbit >> (i*4+j) & 1));
                printf("\n");
            }
            printf("\n");
            */
            if((nbit & val[e.day]) != val[e.day]) continue;
            vector<int> nxt_vec = e.sunny;
            for(int i=0; i<16; i++) {
                if(nbit >> i & 1) {
                    if(nxt_vec[i] + 1 > 6) ok = false;
                    nxt_vec[i]++;
                }
                else {
                    nxt_vec[i] = 0;
                }
            }

            /*
            for(int i=0; i<4; i++) {
                for(int j=0; j<4; j++) {
                    printf("%d", nxt_vec[i*4+j]);
                }
                printf("\n");
            }
            */

            if(ok) {
                Elem nxt{npos, e.day+1, nxt_vec};
                solve(nxt);
            }
        }
    }
}

int main() {
    while(1) {
        S.clear();
        scanf("%d", &N);
        if(!N) break;
        memset(val, 0, sizeof(val));

        for(int i=0; i<N; i++) {
            for(int j=0; j<16; j++) {
                int p; scanf("%d", &p);
                // printf("%d", p);
                // if(j%4 == 3) printf("\n");
                val[i] = (val[i] << 1) | p;
            }
        }

        // 初日の判定
        vector<int> vec(16, 1);
        int bit = (1 << 16) - 1, pos = 5;
        for(int i=0; i<4; i++) {
            int c = d[8][i] + pos;
            bit ^= (1 << c);
            vec[c] = 0;
        }
        if((bit & val[0]) != val[0]) {
            printf("0\n");
            continue;
        }

        ans = false;
        Elem s{pos, 1, vec};
        solve(s);
        printf("%d\n", ans);
    }
    return 0;
}
