#include <bits/stdc++.h>
using namespace std;
typedef long long ll;
const int N = 5e5+5;

#define pii pair<int,int>
#define ff first
#define ss second
#define pb push_back

struct DisjointSet{

    int P[N];
    int R[N];

    DisjointSet(  ){
        memset(R,0,sizeof(R));
        for( int i = 1 ; i < N ; i ++ ){
            P[i] = i;
        }
    }

    int find ( int x ){
        if( x == P[x] ){
            return x;
        }
        return P[x] = find( P[x] );
    }

    void merge ( int x, int y ){
        int px = find(x);
        int py = find(y);
        if( px == py ){
            return;
        }
        if( R[px] > R[py] ){
            P[py] = px;
        }else{
            P[px] = py;
            if( R[px] == R[py] ){
                R[py]++;
            }
        }
    }

}Ds;

int n, m;

struct edge{
    int v, w, ind;
    edge( int _v, int _w, int _ind ){
        v = _v;
        w = _w;
        ind = _ind;
    }
};

bool cmp( edge a , edge b ){
    return a.ind < b.ind;
}
vector <edge> edges;

ll MOD = 1e9+7;
ll fastExpo( ll bas , ll ex ){
    if( ex == 0 ) return 1;
    ll ret = fastExpo( bas , ex/2ll );
    ret = (ret*ret)%MOD;
    if( ex%2ll == 1 ) ret = (ret*bas)%MOD;
    return ret;
}

int main(){

    // freopen("input.txt","r",stdin);
    // freopen("output.txt","w",stdout);

    ios_base::sync_with_stdio(0);
    cin.tie(0);

    cin >> n >> m ;
    for( int i = 0 ; i < n ; i ++ ){
        int k, x, y;
        cin >> k ;
        if( k == 1 ){
            cin >> x ;
            y = m+1;
        }else if( k == 2 ){
            cin >> x >> y ;
        }
        edges.push_back( edge( x , y , i+1 ) );
    }
    //sort( edges.begin() , edges.end() , cmp );

    ll tot = 0;
    set <int> sub;
    for( edge e : edges ){
        if( Ds.find( e.v ) != Ds.find( e.w ) ){
            tot ++;
            sub.insert( e.ind );
            Ds.merge( e.v , e.w );
        }
    }
    cout << fastExpo( 2 , tot ) << " " << tot << endl ;
    for( int x : sub ){
        cout << x << " ";
    }
    cout << endl ;

    return 0;
}