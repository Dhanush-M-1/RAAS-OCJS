#include <bits/stdc++.h>
#define all(a) a.begin(), a.end()
#define db(a) cout << fixed << #a << " = " << a << endl;

using namespace std;

typedef long long ll;
typedef pair<int, int> pii;

const ll MOD = 1e9 + 7;

const int MAXM = 5e5 + 5;

vector<int> parent(MAXM, -1);
vector<int> rank_(MAXM, -1); 
vector<int> indices;

int get_parent(int p) {
	if (parent[p] == p) {
		return p;
	}
	parent[p] = get_parent(parent[p]);
	return parent[p];
}

int main(){
	ios_base::sync_with_stdio(false);
	cin.tie(0);
	int n, m;
	cin >> n >> m;
	vector<ll> pow2(MAXM);
	pow2[0] = 1;
	for (int i = 1; i < MAXM; i++) {
		pow2[i] = pow2[i - 1] * 2;
		pow2[i] %= MOD;
	}
	vector<vector<int>> X(n, vector<int>());
	for (int i = 0; i < n; i++) {
		int k;
		cin >> k;
		if (k == 1) {
			int x1;
			cin >> x1;
			X[i].push_back(x1);
			if (parent[x1] == -1) {
				parent[x1] = x1;
				rank_[x1] = 1;
				indices.push_back(i);
			} else {
				int p1 = get_parent(x1);
				if (rank_[p1] == 1) continue;
				parent[p1] = p1;
				indices.push_back(i);
				rank_[p1] = 1;
			}
		} else {
			int x1, x2;
			cin >> x1 >> x2;
			X[i].push_back(x1);
			X[i].push_back(x2);
			if (parent[x1] == -1 && parent[x2] == -1) {
				int p = x1;
				parent[x1] = p;
				parent[x2] = p;
				indices.push_back(i);
				rank_[p] = 2;
			} else if (parent[x1] == -1) {
				int p = get_parent(x2);
				parent[x1] = p;
				indices.push_back(i);
			} else if (parent[x2] == -1) {
				int p = get_parent(x1);
				parent[x2] = p;
				indices.push_back(i);
			} else {
				int p1 = get_parent(x1);
				int p2 = get_parent(x2);
				if (p1 == p2 || (rank_[p1] == 1 && rank_[p2] == 1)) continue;
				indices.push_back(i);
				parent[p2] = p1;
				rank_[p1] = min(rank_[p1], rank_[p2]);
			}
		}
	}
	vector<set<int>> iP(m + 1, set<int>());
	for (int i: indices) {
		for (int x: X[i]) {
			assert(parent[x] != -1);
			iP[get_parent(x)].insert(x);
		}
	}
	ll ans = 1;
	for (int i = 0; i < m + 1; i++) {
		if (iP[i].empty()) continue;
		int sz = (int) iP[i].size();
		assert(sz > 0);
		if (rank_[i] == 2) {
			ans *= pow2[sz - 1];
		} else {
			ans *= pow2[sz];
		}
		ans %= MOD;
	}
	
	cout << ans << " " << indices.size() << endl;
	for (int i: indices) {
		cout << i + 1 << " ";
	}
	cout << endl;
}

