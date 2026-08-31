#include <iostream>
#include <fstream>
#include <sstream>
#include <string>
#include <algorithm>
#include <vector>
#include <queue>
#include <deque>
#include <stack>
#include <map>
#include <set>
#include <complex>
#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <cmath>
#include <climits>
#include <cctype>
using namespace std;

typedef long long ll;

#define REP(i,n,m) for(int i=n;i<m;i++)
#define rep(i,n) REP(i,0,n)

class State{
public:
  int x,y;
  int day;
  int a,b,c,d;

  State(){}
  State(int _x,int _y,int _day,int _a,int _b,int _c,int _d){
    x = _x;
    y = _y;
    day = _day;
    a = _a;
    b = _b;
    c = _c;
    d = _d;
  }
};

int n;

int dx[] = {0, 1,-1, 0};
int dy[] = {1, 0, 0,-1};

bool t[400][4][4];
bool closed[4][4][400][7][7][7][7];

bool check(State st){
  if(st.a == 7 || st.b == 7 || st.c == 7 || st.d == 7){
    return false;
  }

  for(int i=0;i<2;i++){
    for(int j=0;j<2;j++){
      if(t[st.day][st.y+i][st.x+j]){
        return false;
      }
    }
  }

  return true;
}

int solve(){
  queue<State> open;
  memset(closed,0,sizeof(closed));
  /*
  rep(i,3){
    rep(j,3){
      int a = (i == 0 && j == 0 ? 0 : 1);
      int b = (i == 0 && j == 2 ? 0 : 1);
      int c = (i == 2 && j == 0 ? 0 : 1);
      int d = (i == 2 && j == 2 ? 0 : 1);
      open.push(State(j,i,0,a,b,c,d));
    }
  }
  */
  open.push(State(1,1,0,1,1,1,1));
  while(!open.empty()){
    State st = open.front();
    open.pop();

    if(!check(st)){
      continue;
    }

    if(closed[st.y][st.x][st.day][st.a][st.b][st.c][st.d]){
      continue;
    }
    closed[st.y][st.x][st.day][st.a][st.b][st.c][st.d] = true;

    if(st.day == n){
      return 1;
    }



    rep(i,4){
      rep(j,3){
        int nx = st.x + j * dx[i];
        int ny = st.y + j * dy[i];

        if(nx < 0 || 2 < nx || ny < 0 || 2 < ny){
          continue;
        }

        int na = (nx == 0 && ny == 0 ? 0 : st.a + 1);
        int nb = (nx == 2 && ny == 0 ? 0 : st.b + 1);
        int nc = (nx == 0 && ny == 2 ? 0 : st.c + 1);
        int nd = (nx == 2 && ny == 2 ? 0 : st.d + 1);

        open.push(State(nx,ny,st.day+1,na,nb,nc,nd));
      }
    }
  }

  return 0;
}

int main(){
  while(cin>>n,n){
    rep(i,n){
      rep(j,4){
        rep(k,4){
          cin>>t[i][j][k];
        }
      }
    }

    cout<<solve()<<endl;
  }
}