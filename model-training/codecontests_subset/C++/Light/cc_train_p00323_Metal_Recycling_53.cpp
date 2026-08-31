#include <bits/stdc++.h>
using namespace std;
#define INF 10000000
#define LLINF 100000000000000
typedef long long ll;
typedef pair<int, int> P;
#define pb push_back
#define rep(i, n) for(int i = 0; i < (int)(n); i++)
#define all(x) (x).begin(),(x).end()
#define VSORT(v) sort(v.begin(), v.end());
#define fi first
#define se second
#define out(x) cout << x << endl;
int dx[] = {1, 0, -1, 0}, dy[] = { 0,1,0,-1 };
ll MOD = 1000000007;
struct edge {
	ll from, to, cost;
};

int v[10000005]={0};

int main() {
	int n;
    cin >> n;
    for(int  i = 0; i < n; i++){
        int a,b;
        cin >> a >> b;
        v[a+b]++;
    }
    for(int i = 0; i < 10000000; i++){
        int num = v[i]/2;
        v[i] -= num * 2;
        v[i+1] += num;
    }
    for(int i = 0; i < 10000000; i++){
        if(v[i] > 0){
            cout << i <<" " <<v[i]-1 << endl;
        }
    }
	return 0;
}
