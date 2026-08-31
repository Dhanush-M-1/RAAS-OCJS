#include <bits/stdc++.h>
using namespace std;

constexpr int MAX_N = 365;
constexpr int SIZE = 16;
constexpr int rain[3][3] = {{0x0033, 0x0066, 0x00cc},
							{0x0330, 0x0660, 0x0cc0},
							{0x3300, 0x6600, 0xcc00}};
constexpr int dx[9] = {0, 1, -1, 2, -2, 0, 0, 0, 0};
constexpr int dy[9] = {0, 0, 0, 0, 0, 1, -1, 2, -2};

int n;
int festivals[MAX_N];
unordered_map<int, int> get_index;
unordered_set<int> visited[MAX_N][3][3];

inline int calc_value(int idx, const array<int, 7> &prev) {
	int res = 0;
	for(int i = 0; i < 7; ++i) {
		if(idx != i) res = res * 9 + get_index[prev[i]];
	}
	return res;
}

bool dfs(int day, int x, int y, array<int, 7> &prev) {
	if(day == n) return true;

	const int idx = day % 7;
	const int value = calc_value(idx, prev);
	if(visited[day][x][y].count(value)) return false;


	int need = (1 << SIZE) - 1;
	for(int i = 0; i < 7; ++i) {
		if(idx != i) need &= ~prev[i];
	}

	for(int d = 0; d < 9; ++d) {
		const int nx = x + dx[d];
		const int ny = y + dy[d];
		if(nx < 0 || ny < 0 || nx >= 3 || ny >= 3) continue;
		if(need & ~rain[ny][nx]) continue;
		if(festivals[day] & rain[ny][nx]) continue;

		const int tmp = prev[idx];
		prev[idx] = rain[ny][nx];
		if(dfs(day + 1, nx, ny, prev)) return true;
		prev[idx] = tmp;
	}
	visited[day][x][y].insert(value);
	return false;
}

int main() {
	cin.tie(nullptr);
	ios::sync_with_stdio(false);

	for(int x = 0; x < 3; ++x) {
		for(int y = 0; y < 3; ++y) {
			get_index[rain[y][x]] = y * 3 + x;
		}
	}

	while(cin >> n && n) {
		memset(festivals, 0, sizeof(festivals));
		for(int i = 0; i < n; ++i) {
			for(int j = 0; j < SIZE; ++j) {
				int in;
				cin >> in;
				festivals[i] |= (in << j);
			}
		}

		if(festivals[0] & rain[1][1]) {
			cout << 0 << endl;
			continue;
		}

		array<int, 7> prev;
		prev.fill((1 << SIZE) - 1);
		prev[0] = rain[1][1];

		for(int i = 0; i < n; ++i) {
			for(int x = 0; x < 3; ++x) {
				for(int y = 0; y < 3; ++y) {
					visited[i][x][y].clear();
				}
			}
		}

		cout << dfs(1, 1, 1, prev) << endl;
	}

	return EXIT_SUCCESS;
}