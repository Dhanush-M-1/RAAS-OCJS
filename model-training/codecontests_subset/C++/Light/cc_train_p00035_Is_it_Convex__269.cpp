#include<iostream>
#include<cmath>
using namespace std;
int main(){
char c;
double xa,ya,xb,yb,xc,yc,xd,yd,ab,bc,cd,da,aa,bb,cc,dd;
while(cin>>xa){
cin>>c>>ya>>c>>xb>>c>>yb>>c>>xc>>c>>yc>>c>>xd>>c>>yd;
ab=(xb-xa)*(yc-ya)-(yb-ya)*(xc-xa);
bc=(xc-xb)*(yd-yb)-(yc-yb)*(xd-xb);
cd=(xd-xc)*(ya-yc)-(yd-yc)*(xa-xc);
da=(xa-xd)*(yb-yd)-(ya-yd)*(xb-xd);
if(ab*bc<0||bc*cd<0||cd*da<0||da*ab<0)cout<<"NO"<<endl;
else cout<<"YES"<<endl;
}
return 0;
}