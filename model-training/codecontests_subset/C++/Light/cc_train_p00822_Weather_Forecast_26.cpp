#include<cstdio>
#include<iostream>
#include<cstring>
#include<cmath>
#include<cstdlib>
#include<vector>
#include<stack>
#include<algorithm>
#include<queue>
#include<string>
#define OK 1
#define INF 2147483647
#define LINF 9223372036854775807LL
#define DINF 100000000
#define LL long long
using namespace std;
typedef struct
{
	int cnt[4][4];
}HNode;
vector<HNode>H[366][4][4];
int n,map[365][4][4];
int biao[4][4][4][2];
const int di[] = { 0, 0, 0, -1, -2, 0, 0, 1, 2 };
const int dj[] = { 0, -1, -2, 0, 0, 1, 2, 0, 0 };
bool dfs(int cur, int ci, int cj, int cnt[4][4]);
bool judge(int cur, int ci, int cj, int cnt[4][4]);

int main()
{
	int i,j,k,cnt[4][4];
	while (scanf("%d", &n) > 0)
	{
		if (n == 0) break;
		for (k = 0; k < n; k++)
		{
			for (i = 0; i < 4; i++)
			{
				for (j = 0; j < 4; j++) H[k][i][j].clear();
			}
		}
		for (k = 0; k < n; k++)
		{
			for (i = 0; i < 4; i++)
			{
				for (j = 0; j < 4; j++) scanf("%d", &map[k][i][j]);
			}
		}
		for (i = 0; i < 4; i++)
		{
			for (j = 0; j < 4; j++) cnt[i][j] = 1;
		}
		cnt[1][1] = cnt[1][2] = cnt[2][1] = cnt[2][2] = 0;
		judge(0, 1, 1, cnt);
		if (dfs(0, 1, 1, cnt) == true) printf("1\n");
		else printf("0\n");
	}
	return 0;
}

bool judge(int cur, int ci, int cj, int cnt[4][4])
{
	int k,j,i, len;
	bool flag = false;
	HNode e;
	for (k = 0, len = H[cur][ci][cj].size(); k < len; k++)
	{
		e = H[cur][ci][cj][k];
		flag = true;
		for (i = 0; i < 4; i++)
		{
			for (j = 0; j < 4; j++)
			{
				if (e.cnt[i][j] != cnt[i][j]) flag = false;
			}
		}
		if (flag == true) break;
	}
	if (flag == false)
	{
		for (i = 0; i < 4; i++)
		{
			for (j = 0; j < 4; j++) e.cnt[i][j] = cnt[i][j];
		}
		H[cur][ci][cj].push_back(e);
		return false;
	}
	else return true;
}

bool dfs(int cur,int ci,int cj,int cnt[4][4])
{
	int k,next_ci,next_cj,i,j,nextCnt[4][4];
	if (map[cur][ci][cj] == 1 || map[cur][ci][cj + 1] == 1 || map[cur][ci + 1][cj] == 1 || map[cur][ci + 1][cj + 1] == 1) return false;
	if (cur == n - 1)  return true;
	for (k = 0; k < 9; k++)
	{
		next_ci = ci + di[k];
		next_cj = cj + dj[k];
		if (next_ci < 0 || next_ci + 1 >= 4 || next_cj < 0 || next_cj + 1 >= 4) continue;
		memcpy(nextCnt, cnt, sizeof(nextCnt));
		for (i = 0; i < 4; i++)
		{
			for (j = 0; j < 4; j++) nextCnt[i][j]++;
		}
		nextCnt[next_ci][next_cj] = nextCnt[next_ci][next_cj + 1] = 0;
		nextCnt[next_ci + 1][next_cj] = nextCnt[next_ci + 1][next_cj + 1] = 0;
		bool flag = true;
		for (i = 0; i < 4; i++)  //判断下雨天数
		{
			for (j = 0; j < 4; j++)
			{
				if (nextCnt[i][j] == 7) flag = false;
			}
		}  
		if (flag == false) continue;
		if (judge(cur + 1, next_ci, next_cj, nextCnt) == true) continue;
		if (dfs(cur + 1, next_ci, next_cj, nextCnt) == true) return true;
 	}
	return false;
}