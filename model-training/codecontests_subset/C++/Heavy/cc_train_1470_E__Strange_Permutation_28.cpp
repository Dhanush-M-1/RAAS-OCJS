#include <iostream>
#include <tuple>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

using ll = long long;
using ull = unsigned long long;
using PP = pair<int, int>;

constexpr int maxn = 3e4 + 10;

struct Node
{
	int l, r;
	ull w = 0;
	Node() {}
	Node(int _l, int _r, ull _w) :l(_l), r(_r), w(_w) {}
};

ull Com[maxn][5];

Node fun(int x, ull k, vector<PP>& L, vector<Node>& que)
{
	int l, r;
	tie(l, r) = L[x];
	int lb = l - 1;
	int ans = -1;

	while (l < r)
	{
		int m = (l + r) >> 1;
		if (que[m].w - que[lb].w >= k)
		{
			ans = m;
			r = m;
		}
		else
			l = m + 1;
	}
	return { que[ans].l,que[ans].r,que[ans - 1].w - que[lb].w };
}
ull SC(int a, int b)
{
	if (a < 0)
		return 1;
	ull ans = 0;
	for (int i = 0; i <= b; i++)
		ans += Com[a][i];
	return ans;
}
int main()
{
    ios_base::sync_with_stdio(false);
	int T;
	cin >> T;
	int r[5] = { 1,1,2,6,24 };
	for (int i = 0; i <= 3e4; i++)
		Com[i][0] = 1;
	for (int j = 1; j <= 4; j++)
	{
		ull sum = 1;
		for (int i = 1; i <= 3e4; i++)
		{
			if (i == 3e4)
				i = i;
			if (i > j)
				sum /= (ull)(i - j);
			sum *= i;
			if (i >= j)
				Com[i][j] = sum / r[j];
		}
	}

	while (T--)
	{
		int N, C, Q;
		cin >> N >> C >> Q;
		ll tot = SC(N - 1, C);
		vector<int>P(N + 1);
		for (int i = 1; i <= N; i++)
			cin >> P[i];

		const int que_len = 2 * N * C + 10;
		vector<vector<Node>>que(5, vector<Node>(que_len));
		vector<vector<PP>>L(5, vector<PP>(N + 1));
		for (int c = 1; c <= C; c++)
		{
			int l = N * C + 2, r = N * C + 2;
			que[c][r++] = { -1, -1, 1 };
			L[c][N] = { l,r };
			for (int i = N - 1; i >= 1; i--)
			{
				vector<int>t_vec;
				const int ite_c = min(N - i, c);
				for (int j = 1; j <= ite_c; j++)
					t_vec.push_back(j);
				sort(t_vec.begin(), t_vec.end(), [&](const int& a, const int& b)
					{
						int fa = P[i + a] - P[i];
						int fb = P[i + b] - P[i];
						if (fa * fb < 0)
							return fa < fb;
						else
							return 1ll * fa * fa < 1ll * fb * fb;
					});
				for (auto j : t_vec)
				{
					Node tmp = { i, i + j, SC(N - (i + j) - 1,c - j) };
					if (P[i + j] > P[i])
						que[c][r++] = tmp;
					else
						que[c][--l] = tmp;
				}
				L[c][i] = { l,r };
			}
			for (int i = l; i < r; i++)
				que[c][i].w += que[c][i - 1].w;
		}

		while (Q--)
		{
			ull n, k;
			int c = C;
			cin >> n >> k;
			if (k > tot)
			{
				cout << -1 << "\n";
				continue;
			}
			int x = 1;
			while (true)
			{
				auto t = fun(x, k, L[c], que[c]);
				x = t.r + 1;
				k -= t.w;
				c -= t.r - t.l;
				if (t.l <= n && n <= t.r)
				{
					cout << P[t.r - n + t.l] << "\n";
					break;
				}
				if (c == 0 || n < t.l || t.l == -1)
				{
					cout << P[n] << "\n";
					break;
				}
			}
		}
	}
}