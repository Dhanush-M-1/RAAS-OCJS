#include<bits/stdc++.h>
using namespace std;

multiset<int> ms;
int fl[100005];

int main() {
  int x,n;
  scanf("%d%d",&x,&n);
  for(int i=0;i<n;i++) scanf("%d",fl+i);
  fl[n] = 1e9+7;
  int q,i=0,pt=0,lb=0, lv=0, rb=x, rv=x;
  bool up=false;
  scanf("%d",&q);
  while(q--) {
    int t,a;
    scanf("%d%d",&t,&a);
    while(pt<t) {
      if(fl[i] > t) {
        int v = (up?1:-1)*(t-pt);
        lv += v;
        rv += v;
        pt = t;
      } else {
        int v = (up?1:-1)*(fl[i]-pt);
        up = !up;
        pt = fl[i++];
        lv += v;
        rv += v;
      }
      if(rv > x) {
        rb -= rv-x;
        rv = x;
        if(lv > x) {
          lb = rb;
          lv = x;

        }
      }
      if(lv < 0) {
        lb -= lv;
        lv = 0;
        if(rv < 0) {
          rb = lb;
          rv = 0;
        }
      }
      if(lb<0) lb = 0;
      if(lb>x) lb = x;
      if(rb<0) rb = 0;
      if(rb>x) rb = x;
    }
    if(a <= lb) printf("%d\n",lv);
    else if(a >= rb) printf("%d\n",rv);
    else printf("%d\n",lv + (a-lb));
  }
}
