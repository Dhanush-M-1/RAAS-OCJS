#include<bits/stdc++.h>
using namespace std;
#define int long long
signed main(){
  int x,k;
  cin>>x>>k;
  int r[k];
  for(int i=0;i<k;i++) cin>>r[i];
  int q;
  cin>>q;
  int t[q],a[q];
  for(int i=0;i<q;i++) cin>>t[i]>>a[i];

  int L=0,R=x;//[L,R]
  int lb[k],ub[k];
  fill_n(lb,k,0);
  fill_n(ub,k,x);
  
  int j=0,p=0,d=0;
  int lv=0,uv=x;
  for(int i=0;i<q;i++){
    while(j<k&&r[j]<=t[i]){
      if(j%2==0) p+=r[j]-d;
      else p-=r[j]-d;
      if(j%2==0){
	lv=max(lv-(r[j]-d),0LL);
	uv=max(uv-(r[j]-d),0LL);
      }else{
	lv=min(lv+(r[j]-d),x);
	uv=min(uv+(r[j]-d),x);
      }
      
      L=max(L,p);
      R=min(R,x+p);
      lb[j]=L;
      ub[j]=R;
      d=r[j++];
      
      
    }
    //cout<<i<<" "<<j<<":"<<p<<endl;
    //cout<<L<<" "<<R<<endl;
    if(L<=a[i]&&a[i]<=R){
      int c=a[i]-p;
      if(j%2==0) c=max(c-(t[i]-d),0LL);
      else c=min(c+(t[i]-d),x);
      cout<<c<<endl;
    }else if(a[i]<L){
      int c=lv;
      if(j%2==0) c=max(c-(t[i]-d),0LL);
      else c=min(c+(t[i]-d),x);
      cout<<c<<endl;
    }else if(R<a[i]){
      int c=uv;
      if(j%2==0) c=max(c-(t[i]-d),0LL);
      else c=min(c+(t[i]-d),x);
      cout<<c<<endl;
    }else{
      cout<<"?"<<endl;
    }
  }
  return 0;
}
