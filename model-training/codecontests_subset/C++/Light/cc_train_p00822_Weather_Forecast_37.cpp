#include<bits/stdc++.h>
using namespace std;
int n;
vector<int> v;
typedef pair<int,vector<int> > P;
map<P,bool> mv;
int ax[]={0,1,2,-1,-2,0,0,0,0};
int ay[]={0,0,0,0,0,1,2,-1,-2};
int in(int y,int x){
  return 0<=y&&y<3&&0<=x&&x<3;
}
int in2(int y,int x){
  return 0<=y&&y<4&&0<=x&&x<4;
}
bool solve(int d,vector<int> m){
  if(d==n-1) return true;
  if(mv.count(P(d,m))) return mv[P(d,m)];
  int y=m[0]/3,x=m[0]%3;
  for(int k=0;k<9;k++){
    int ny=y+ay[k],nx=x+ax[k];
    if(!in(ny,nx)) continue;
    bool f=0;
    for(int i=0;i<2;i++){
      for(int j=0;j<2;j++){
	int ty=ny+i,tx=nx+j;
	if(!in2(ty,tx)) continue;
	if((v[d+1]>>(ty*4+tx))&1) f=1;
      }
    }
    if(f) continue;
    if(d>4){
      int a[4][4]={};
      for(int l=0;l<6;l++){
	int dy=m[l]/3,dx=m[l]%3;
	for(int i=0;i<2;i++){
	  for(int j=0;j<2;j++){
	    int ty=dy+i,tx=dx+j;
	    if(!in2(ty,tx)) continue;
	    a[ty][tx]++;
	  }
	}
      }
      for(int i=0;i<2;i++){
	for(int j=0;j<2;j++){
	  int ty=ny+i,tx=nx+j;
	  if(!in2(ty,tx)) continue;
	  a[ty][tx]++;
	}
      }
      for(int i=0;i<4;i++)
	for(int j=0;j<4;j++)
	  if(!a[i][j]) f=1;
    }
    
    vector<int> u(6);
    for(int i=1;i<6;i++) u[i]=m[i-1];
    u[0]=ny*3+nx;
    if(f) continue;
    if(solve(d+1,u)) return mv[P(d,m)]=true;
  }
  return mv[P(d,m)]=false;
}
signed main(){
  while(cin>>n,n){
    v.resize(n);
    for(int i=0;i<n;i++){
      v[i]=0;
      for(int j=0,k;j<16;j++){
	cin>>k;
	v[i]+=(1<<j)*k;
      }
    }
    vector<int> m(6,-1);
    m[0]=4;
    mv.clear();
    bool f=0;
    for(int i=0;i<2;i++){
      for(int j=0;j<2;j++){
	int ty=1+i,tx=1+j;
	if((v[0]>>(ty*4+tx))&1) f=1;
      }
    }
    //cout<<"f:"<<f<<endl;
    if(f) cout<<0<<endl;
    else  cout<<solve(0,m)<<endl;
  }
  return 0;
}