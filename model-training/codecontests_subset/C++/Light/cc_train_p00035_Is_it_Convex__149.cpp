#include <iostream>
#include <algorithm>
#include <cassert>
#include <cctype>
#include <complex>
#include <cstdio>
#include <map>
#include <math.h>
#include <queue>
#include <set>
#include <stack>
#include <string>
#include <vector>
using namespace std;

#define rep(i,n) for(int i=0;i<n;i++)
typedef complex<double> P;

char c;
double x,y,xx,yy,xxx,yyy,xxxx,yyyy;

double cr(P a, P b) {
  return (a.real() * b.imag() - a.imag() * b.real());
}

int main(){
	while(cin>>x>>c>>y>>c>>xx>>c>>yy>>c>>xxx>>c>>yyy>>c>>xxxx>>c>>yyyy){
		P a=P(x,y),b=P(xx,yy),c=P(xxx,yyy),d=P(xxxx,yyyy);
		int C=cr(d-a,b-a)>0&&cr(a-b,c-b)>0&&cr(b-c,d-c)>0&&cr(c-d,a-d)>0||cr(d-a,b-a)<0&&cr(a-b,c-b)<0&&cr(b-c,d-c)<0&&cr(c-d,a-d)<0;
		cout<<(C?"YES":"NO")<<endl;
	}
}