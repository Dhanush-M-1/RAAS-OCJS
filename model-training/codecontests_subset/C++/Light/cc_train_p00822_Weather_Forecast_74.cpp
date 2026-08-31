#include<iostream>
#include<queue>
#include<bitset>
#include<cassert>
#include<vector>
#include<algorithm>
#include<climits>
#include<cstdio>

#define REP(i,s,n) for(int i=s;i<n;i++)
#define rep(i,n) REP(i,0,n)
#define IINF (INT_MAX)
#define MAX 366

using namespace std;

int dx[] = {+0,+1,+0,-1,+0,+2,+0,-2,+0};
int dy[] = {+1,+0,-1,+0,+2,+0,-2,+0,+0};
int n;
int fest[MAX];
bool visited[MAX][9][7][7][7][7];

bool isValid(int day,int cur)
{
  if((fest[day]>>cur) & 1)return false;
  if((fest[day]>>(cur+1)) & 1)return false;
  if((fest[day]>>(cur+4)) & 1)return false;
  if((fest[day]>>(cur+5)) & 1)return false;
  return true;
}

bool dfs(int day,int cur,int _1,int _3,int _9,int _11)
{
  //cout << day << "," << cur << "," << _1 << "," << _3 << "," << _9 << "," << _11 << endl;

  if(visited[day][cur-(1*(cur/4))][_1][_3][_9][_11])return false;
  visited[day][cur-(1*(cur/4))][_1][_3][_9][_11] = true;

  if(!isValid(day,cur))
    {
      return false;
    }  

  if(day >= n-1)
    {
      return true;
    }

  int x = cur % 4;
  int y = cur / 4;

  rep(i,9)
    {
      int nx = x + dx[i];
      int ny = y + dy[i];
      if(!(0 <= nx && nx <= 2 && 0 <= ny && ny <= 2))continue;
      int next = nx + ny * 4;
      int cost1 = _1+1;
      int cost3 = _3+1;
      int cost9 = _9+1;
      int cost11 = _11+1;
      if(next == 0)cost1 = 0;
      if(next == 2)cost3 = 0;
      if(next == 8)cost9 = 0;
      if(next == 10)cost11 = 0;
      if(cost1 >= 7 || cost3 >= 7 || cost9 >= 7 || cost11 >= 7)continue;
      //cout << "go next (" << day+1 << "," << next << "," << cost1 << "," <<cost3 << "," << cost9 << "," << cost11 << ")\n";
      if(dfs(day+1,next,cost1,cost3,cost9,cost11))
	{
	  return true;
	}
    }
  return false;
}

int main()
{
  while(scanf("%d",&n),n)
    {
      rep(i,n)
	{
	  fest[i] = 0;
	  int schedule;
	  rep(j,16)
	    {
	      scanf("%d",&schedule);
	      if(schedule)
		{
		  fest[i] |= (1<<j);
		}
	    }
	}

      rep(i,n+1)rep(j,9)rep(k,7)rep(l,7)rep(m,7)rep(o,7)
	visited[i][j][k][l][m][o] = false;

      cout << dfs(0,5,1,1,1,1) << endl;

    }
  return 0;
}