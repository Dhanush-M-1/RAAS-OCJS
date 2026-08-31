#include <bits/stdc++.h>
using namespace std;

#define INF (INT64_MAX)
#define MOD (1000000000+7)
#define MAX 200000

int N;
long long D;
long long A[MAX + 1];

typedef pair<int, int> P;
typedef pair<long long, P> Edge;
vector<Edge> edges;

struct UnionFind {
    vector<int> par;
    
    UnionFind(int n) : par(n, -1) { }
    void init(int n) { par.assign(n, -1); }
    
    int root(int x) {
        if (par[x] < 0) return x;
        else return par[x] = root(par[x]);
    }
    
    bool issame(int x, int y) {
        return root(x) == root(y);
    }
    
    bool merge(int x, int y) {
        x = root(x); y = root(y);
        if (x == y) return false;
        if (par[x] > par[y]) swap(x, y); // merge technique
        par[x] += par[y];
        par[y] = x;
        return true;
    }
    
    int size(int x) {
        return -par[root(x)];
    }
};

template<class T> inline bool chmax(T& a, T b) { if (a < b) { a = b; return 1; } return 0; }
template<class T> inline bool chmin(T& a, T b) { if (a > b) { a = b; return 1; } return 0; }

void rec(int left, int right)
{
    if (right - left <= 1) return;
    int mid = (left + right) / 2;
    
    long long leftmin = 1LL<<60;
    int leftminp = -1;
    for (int i = left; i < mid; ++i) if (chmin(leftmin, A[i]-D*i)) leftminp = i;
    long long rightmin = 1LL<<60;
    int rightminp = -1;
    for (int i = mid; i < right; ++i) if (chmin(rightmin, A[i]+D*i)) rightminp = i;
    
    for (int i = left; i < mid; ++i)
        edges.push_back(make_pair(A[rightminp] + A[i] + D * (rightminp - i), make_pair(i, rightminp)));
    for (int i = mid; i < right; ++i)
        edges.push_back(make_pair(A[leftminp] + A[i] + D * (i - leftminp), make_pair(leftminp, i)));
    
    rec(left, mid);
    rec(mid, right);
}

int main() {
	cin >> N >> D;
	for( int i = 0; i < N; i++ ) {
		cin >> A[i];
	}

	rec( 0, N );
	sort( edges.begin(), edges.end() );
	UnionFind uf( N );
	long long ans = 0;
	for( int i = 0; i < edges.size(); i++ ) {
		Edge e = edges[i];
		if( !uf.issame( e.second.first, e.second.second ) ) {
			uf.merge( e.second.first, e.second.second );
			ans += e.first;
		}
	}

	cout << ans << endl;

	return 0;
}
