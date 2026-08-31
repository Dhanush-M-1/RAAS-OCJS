#include <bits/stdc++.h>

#define fi first
#define se second
#define ll long long
#define dl double long

using namespace std;

const int N = 3e4 + 7;
const long long mod = 998244353;

mt19937 rng(chrono::steady_clock::now().time_since_epoch().count());

int n,c,q;
int p[N];
ll d[N][5];

ll L[N][5];
ll R[N][5];

vector < int > v[N][5];

void solve()
{
    cin >> n >> c >> q;
    for( int i = 1; i <= n; i++ ){
        cin >> p[i];
    }
    for( int i = 0; i <= c; i++ )d[n + 1][i] = 1;
    for( int i = 0; i <= n; i++ ){
        for( int j = 0; j <= c; j++ ){
            L[i][j] = R[i][j] = 0;
            v[i][j].clear();
        }
    }
    for( int i = n; i >= 1; i-- ){
        for( int j = 0; j <= c; j++ ){
            d[i][j] = d[i + 1][j];
            vector < pair < int , int > > g;
            g.push_back({ p[i] , 0 });
            for( int h = 1; h <= j; h++ ){
                if( i + h <= n ){
                    g.push_back({ p[i + h] , h });
                    d[i][j] += d[i + h + 1][j - h];
                }
            }
            sort( g.begin() , g.end() );
            for( auto x : g ){
                v[i][j].push_back(x.se);
            }
        }
    }
    for( int i = 0; i <= c; i++ ){
        for( int j = 1; j <= n; j++ ){
            for( auto x : v[j][i] ){
                if( x == 0 ){
                    R[j][i] += d[j + 1][i];
                    break;
                }else{
                    L[j][i] += d[j + x + 1][i - x];
                    R[j][i] += d[j + x + 1][i - x];
                }
            }
        }
    }
    for( int i = 0; i <= c; i++ ){
        for( int j = 1; j <= n; j++ ){
            L[j][i] += L[j - 1][i];
        }
    }
    while( q-- ){
        int i;
        ll j;
        cin >> i >> j;
        if( j > d[1][c] ){
            cout << "-1\n";
            continue;
        }
        vector < pair < int , int > > seg;
        int st = 1;
        int nc = c;
        while( st <= n ){
            int l = st , r = n + 1;
            while( l < r ){
                int m = (l + r) / 2;
                if( L[m][nc] - L[st - 1][nc] < j && j <= L[m - 1][nc] - L[st - 1][nc] + R[m][nc] ){
                    l = m + 1;
                }else r = m;
            }
            if( l == n + 1 )break;
            j -= L[l - 1][nc] - L[st - 1][nc];
            st = l;
            for( auto x : v[st][nc] ){
                if( j > d[st + x + 1][nc - x] ){
                    j -= d[st + x + 1][nc - x];
                }else{
                    seg.push_back({ st , st + x });
                    st += x + 1;
                    nc -= x;
                    break;
                }
            }
        }
        vector < int > f;
        for( auto x : seg ){
            if( x.fi <= i && i <= x.se ){
                for( int h = x.fi; h <= x.se; h++ ){
                    f.push_back(p[h]);
                }
                i -= x.fi;
                break;
            }
        }
        if( f.empty() ){
            cout << p[i] << "\n";
            continue;
        }
        reverse( f.begin() , f.end() );
        cout << f[i] << "\n";
    }
}

int main()
{
    ios_base::sync_with_stdio(0);
    //freopen( "input.txt" , "r" , stdin );
    //freopen( "output.txt" , "w" , stdout );

    int T;
    cin >> T;
    while( T-- ){
        solve();
    }
}
