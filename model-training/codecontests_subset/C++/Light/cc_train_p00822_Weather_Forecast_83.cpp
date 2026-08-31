#include <bits/stdc++.h>
using namespace std;

int bit[16];

int memo[366][9][7][7][7][7];
constexpr int idx[9] = {0, 1, 2, 4, 5, 6, 8, 9, 10};

array<array<int, 5>, 9> to = {{{0, 1, 2, 3, 6},
    {0, 1, 2, 4, 7},
    {0, 1, 2, 5, 8},
    {0, 3, 4, 5, 6},
    {1, 3, 4, 5, 7},
    {2, 3, 4, 5, 8},
    {0, 3, 6, 7, 8},
    {1, 4, 6, 7, 8},
    {2, 5, 6, 7, 8}}};
tuple<int, int, int, int> calc(int d, int d1, int d2, int d3, int d4) {
    if(d == 0) {
        d1 = 0;
        d2++; d3++; d4++;
    } else if(d == 2) {
        d2 = 0;
        d1++; d3++; d4++;
    } else if(d == 6) {
        d3 = 0;
        d1++; d2++; d4++;
    } else if(d == 8) {
        d4 = 0;
        d1++; d2++; d3++;
    } else {
        d1++; d2++; d3++; d4++;
    }
    return make_tuple(d1, d2, d3, d4);
}

bool solve(int d, int now, int d1, int d2, int d3, int d4, vector<int> const& v) {
    int& r = memo[d][now][d1][d2][d3][d4];
    if(r != -1) {
        return r;
    }
    if(v[d] & bit[idx[now]]) {
        return r = false;
    }
    if(d == v.size()-1) {
        return r = true;
    }
    bool f = false;
    for(int i=0; i<5; ++i) {
        int to2 = to[now][i];
        auto t = calc(to2, d1, d2, d3, d4);
        if(get<0>(t) == 7 || get<1>(t) == 7 || get<2>(t) == 7 || get<3>(t) == 7) {
            continue;
        }
        f |= solve(d+1, to2, get<0>(t), get<1>(t), get<2>(t), get<3>(t), v);
    }
    
    return r = f;
}

int main() {
    int init = 0b1100110000000000;
    for(int i=0; i<16; ++i) {
        bit[i] = init;
        init >>= 1;
    }
    int D;
    while(cin >> D, D) {
        vector<int> v(D);
        for(int i=0; i<D; ++i) {
            int bit = 0;
            for(int j=0; j<16; ++j) {
                bit <<= 1;
                int b;
                cin >> b;
                bit += b;
            }
            v[i] = bit;
        }
        for(int i=0; i<366; ++i) {
            for(int j=0; j<9; ++j) {
                for(int k=0; k<7; ++k) {
                    for(int l=0; l<7; ++l) {
                        for(int m=0; m<7; ++m) {
                            for(int n=0; n<7; ++n) {
                                memo[i][j][k][l][m][n] = -1;
                            }
                        }
                    }
                }
            }
        }
        //fill(memo[0][0][0][0][0], memo[366][9][7][7][7], -1);
        cout << solve(0, 4, 1, 1, 1, 1, v) << endl;
    }
}
