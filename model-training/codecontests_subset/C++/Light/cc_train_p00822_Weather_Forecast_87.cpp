#include <bits/stdc++.h>
using namespace std;
#define rep(i,a,b) for(int i=a;i<b;i++)

int n;
int t[365][4][4];
map<int, int> memo;

int dfs(int day, int x, int y, int lu, int ru, int lb, int rb)
{
	int id = day;
	id = id * 10 + x;	id = id * 10 + y;	id = id * 10 + lu;
	id = id * 10 + ru;	id = id * 10 + lb;	id = id * 10 + rb;

	if (memo.find(id) != memo.end()) return memo[id];

	if(day == n) return (memo[id] = 1);

	rep(i, 0, 2) rep(j, 0, 2)
	{
		int xx = x + i;
		int yy = y + j;

		if (t[day][yy][xx] == 1) return (memo[id] = 0);
	}

	if (lu == 7) return (memo[id] = 0);
	if (ru == 7) return (memo[id] = 0);
	if (lb == 7) return (memo[id] = 0);
	if (rb == 7) return (memo[id] = 0);

	rep(xx, 0, 3) rep(yy, 0, 3)
	{
		if (x != xx && y != yy) continue;

		int ret;
		if (xx == 0 && yy == 0)
			ret = dfs(day + 1, xx, yy, 0, ru + 1, lb + 1, rb + 1);
		else if(xx == 0 && yy == 2)
			ret = dfs(day + 1, xx, yy, lu + 1, ru + 1, 0, rb + 1);
		else if(xx == 2 && yy == 0)
			ret = dfs(day + 1, xx, yy, lu + 1, 0, lb + 1, rb + 1);
		else if(xx == 2 && yy == 2)
			ret = dfs(day + 1, xx, yy, lu + 1, ru + 1, lb + 1, 0);
		else
			ret = dfs(day + 1, xx, yy, lu + 1, ru + 1, lb + 1, rb + 1);

		if(ret) return (memo[id] = 1);
	}

	return (memo[id] = 0);
}

int main()
{
	cin.tie(0);
	ios::sync_with_stdio(false);

	while (1)
	{
		cin >> n;
		if (n == 0) return 0;

		memo.clear();
		rep(i, 0, n) rep(j, 0, 4) rep(k, 0, 4) cin >> t[i][j][k];

		cout << dfs(0, 1, 1, 1, 1, 1, 1) << endl;
	}
}