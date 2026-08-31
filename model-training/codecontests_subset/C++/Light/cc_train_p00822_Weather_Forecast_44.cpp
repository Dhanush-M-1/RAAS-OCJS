#include<iostream>
#include<algorithm>
using namespace std;
#define REP(i,b,n) for(int i=b;i<n;i++)
#define rep(i,n)   REP(i,0,n)

bool vis[366][4][4][8][8][8][8]={0};
bool isevent[366][4][4];

int dx[]={-2,-1, 0, 0,1,2,0,0,0};
int dy[]={ 0, 0,-2,-1,0,0,1,2,0};

bool canstay(int day,int tary,int tarx){
  rep(i,2){
    rep(j,2){
      if (isevent[day][tary+i][tarx+j])return false;
    }
  }
  return true;
}

bool is_rain_full(int cur[4][4]){
  rep(i,4){
    rep(j,4){
      if (cur[i][j] == 7)return false;
    }
  }
  return true;
}

void rain(int ney,int nex,int cur[4][4]){
  rep(i,4){
    rep(j,4){
      cur[i][j]++;
    }
  }
  rep(i,2){
    rep(j,2){
      cur[ney+i][nex+j]=0;
    }
  }
}

bool dfs(int n,int now,int y,int x,
       int lu,int ru,int ld,int rd,
	 int cur[4][4]){

  if (!is_rain_full(cur))return false;
  if (n == now){
    return true;
  }


  if (!canstay(now,y,x) )return false;
  rain(y,x,cur);


  if (vis[now][y][x][lu][ru][ld][rd])return false;
  vis[now][y][x][lu][ru][ld][rd]=true;
  



  int tmp[4][4];
  rep(k,9){
    int nex=x+dx[k],ney=y+dy[k];
    if (nex < 0|| ney < 0||
	nex > 2|| ney > 2)continue;
    rep(i,4)rep(j,4)tmp[i][j]=cur[i][j];
    if (dfs(n,now+1,ney,nex,
	    cur[0][0],cur[0][3],
	    cur[3][0],cur[3][3],
	    cur))return true;
    rep(i,4)rep(j,4)cur[i][j]=tmp[i][j];
  }
  return false;
}

int main(){
  int n;
  while(cin>>n && n){
    rep(k,n){
      rep(i,4)
	rep(j,4)cin>>isevent[k][i][j];
    }
    rep(i,4)rep(j,4)isevent[n][i][j]=0;
    rep(i,n)
      rep(j,4)
      rep(k,4)
      rep(l,8)
      rep(m,8)
      rep(o,8)
      rep(p,8)
      vis[i][j][k][l][m][o][p]=false;
    
    int cur[4][4]={0};
    cout << dfs(n,0,1,1,0,0,0,0,cur)<<endl;
  }
  return false;
}