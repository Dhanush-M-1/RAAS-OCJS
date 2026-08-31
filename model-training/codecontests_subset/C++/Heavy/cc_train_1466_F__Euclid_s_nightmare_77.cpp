//Challenge: Accepted
#include <iostream>
#include <algorithm>
#include <vector>
#include <utility>
#include <string>
#include <stack>
#include <queue>
#define ll long long
#define pii pair<int, int>
#define maxn 500005
#define mod 1000000007
#define Goodbye2020 ios_base::sync_with_stdio(0);cin.tie(0);
using namespace std;
struct edge{
	int a, b, ind;
	edge(int x, int y, int z) {
		a = x, b = y, ind = z;
	}
};
vector<edge> v;
vector<int> ans;
int par[maxn];
int find(int a) {
	return (a == par[a] ? a : par[a] = find(par[a]));
}
void Union(int a, int b) {
	par[find(a)] = find(b);
}
ll modpow(int p) {
	ll ret = 1, mult = 2;
	while (p) {
		if (p & 1) ret = (ret * mult) % mod;
		mult = (mult * mult) % mod;
		p >>= 1;
	}
	return ret;
}
int main() {
	Goodbye2020
	int n, m;
	cin >> n >> m;
	for (int i = 0;i <= m;i++) par[i] = i;
	for (int i = 0;i < n;i++) {
		int k;
		cin >> k;
		int ed[2] = {0, 0};
		for (int j = 0;j < k;j++) {
			cin >> ed[j];
		}
		v.push_back(edge(ed[0], ed[1], i));
	}
	int cnt = n;
	for (int i = 0;i < n;i++) {
		if (find(v[i].a) != find(v[i].b)) {
			Union(v[i].a, v[i].b);
			ans.push_back(v[i].ind + 1);
		} else {
			cnt--;
		}
	}
	cout << modpow(cnt) << " " << ans.size() << "\n";
	for (int i = 0;i < ans.size();i++) cout << ans[i] << " ";
	cout << endl;
}
