#include <iostream>
#include <sstream>
#include <vector>
#include <algorithm>
#include <numeric>
#include <cmath>
#include <utility>
#include <map>
#include <list>
#include <climits>
#include <set>
#include <deque>
#include <queue>
#include <stack>
#include <unordered_map>
#include <unordered_set>
#include <iomanip>
#include <bitset>
#include <string>

// #define cerr if(false)cerr
#define watch(x) cerr << "> " << #x << ": " << x << "\n";

using namespace std;

template <typename T>
std::ostream &operator <<(std::ostream &out, vector<T> &v) {
	for (typename vector<T>::size_type i = 0; i < v.size(); ++i)
		out << v[i] << " ";
	out << "\n";
    return out;
}
template <typename T>
std::ostream &operator <<(std::ostream &out, set<T> &s) {
	for (auto e : s)
		out << e << " ";
	out << "\n";
    return out;
}
template <typename T, typename N>
std::ostream &operator <<(std::ostream &out, pair<T, N> &p) {
	out << "(" << p.first << ", " << p.second << ") ";
    return out;
}
template <typename T, typename N>
std::ostream &operator <<(std::ostream &out, vector<pair<T, N> > &v) {
	for (size_t i = 0; i < v.size(); ++i)
		cout << v[i];
	out << "\n";
    return out;
}
template <typename T, typename N>
std::ostream &operator <<(std::ostream &out, set<pair<T, N> > &s) {
	for (auto p : s)
		out << p;
	out << "\n";
    return out;
}
template <typename T>
std::ostream &operator <<(std::ostream &out, vector<vector<T> > &v) {
	for (size_t i = 0; i < v.size(); ++i) {
		for (size_t j = 0; j < v[i].size(); ++j) {
			out << v[i][j] << " ";
		}
		out << "\n";
	}
   	return out;
}
template <typename T>
std::ostream &operator <<(std::ostream &out, vector<set<T> > &v) {
	for (size_t i = 0; i < v.size(); ++i) {
		out << v[i];
	}
	out << "\n";
   	return out;
}

void solve() {
	int k, n, m;
	cin >> k >> n >> m;

	vector<int> a(n), b(m);
	for (int i = 0; i < n; ++i) {
		cin >> a[i];
	}

	for (int i = 0; i < m; ++i) {
		cin >> b[i];
	}

	vector<int> seq;
	int i = 0, j = 0;
	while (i < n && j < m) {
		if (a[i] > k && b[j] > k) {
			cout << "-1\n";
			return ;
		}

		if (b[j] == 0) {
			++k;
			++j;
			seq.push_back(0);
		} else {
			if (b[j] <= k) {
				seq.push_back(b[j]);
				++j;
			}
		}

		if (a[i] == 0) {
			++k;
			seq.push_back(0);
			++i;
		} else {
			if (a[i] <= k) {
				seq.push_back(a[i]);
				++i;
			}
		}
	}

	while (i < n) {
		if (a[i] == 0) {
			++k;
			seq.push_back(0);
			++i;
		} else {
			if (a[i] <= k) {
				seq.push_back(a[i]);
				++i;
			} else {
				cout << "-1\n";
				return ;
			}
		}
	}

	while (j < m) {
		if (b[j] == 0) {
			++k;
			++j;
			seq.push_back(0);
		} else {
			if (b[j] <= k) {
				seq.push_back(b[j]);
				++j;
			} else {
				cout << "-1\n";
				return ;
			}
		}
	}

	cout << seq;
	
	return ;
}

int main() {

	std::ios::sync_with_stdio(false);
	cin.tie(0);
	cout.tie(0);

	int t;
	cin >> t;

	while (t--) {
		solve();
	}

	return 0;

}