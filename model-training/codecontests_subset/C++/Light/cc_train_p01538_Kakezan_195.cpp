#include <cstdlib>
#include <iostream>
#include <map>
using namespace std;

template<class T> inline void chmax(T& a, const T& b) { if(b > a) a = b; }

map<int, int> visited;
int dfs(int n) {
	if(n < 10)
		return 0;

	if(visited.count(n))
		return visited[n];

	visited[n] = -1;
	int next = 0;
	for(int i = 10; n / i; i *= 10) {
		int a = n / i;
		int b = n % i;
		chmax(next, a * b);
	}

	return visited[n] = dfs(next) + 1;
}

int main() {
	cin.tie(0);
	ios::sync_with_stdio(false);

	int q;
	cin >> q;

	for(int i = 0; i < q; ++i) {
		int n;
		cin >> n;

		cout << dfs(n) << endl;
	}

	return EXIT_SUCCESS;
}