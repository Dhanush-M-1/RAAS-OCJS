#include <string>
#include <vector>
#include <sstream>
#include <iostream>
#include <algorithm>
#include <map>
#include <list>
#include <set>
#include <numeric>
#include <queue>
#include <stack>
#include <cstdio>
#include <cmath>
#include <cstdlib>
#include <cctype>
#include <cstring>
#include <climits>
#include <cfloat>
#include <ctime>
#include <complex>
#include <cassert>
#include <array>
#include <bitset> 
#include <unordered_map>
#include <random>

using namespace std;
typedef long long LL;
typedef pair<int,int> P;

const int L=1e5+1;
int X;
int K;
int r[L];
int b[L];
int u[L];
int l[L];
int main() {
	scanf("%d%d",&X,&K);
	for(int i=1;i<=K;i++){
		scanf("%d",r+i);
	}
	u[0]=X;
	for(int i=1;i<=K;i++){
		int d;
		if(i%2){
			d=-r[i]+r[i-1];
		}
		else{
			d=r[i]-r[i-1];
		}
		b[i]=b[i-1]+d;
		u[i]=u[i-1]+d;
		l[i]=l[i-1]+d;
		u[i]=max(0,min(X,u[i]));
		l[i]=max(0,min(X,l[i]));
	}
	int Q;
	scanf("%d",&Q);
	for(int i=0;i<Q;i++){
		int t,a;
		scanf("%d%d",&t,&a);
		int p=upper_bound(r,r+K+1,t)-r;
		p--;
		int s=a+b[p];
		if(s<l[p]){
			s=l[p];
		}
		else if(u[p]<s){
			s=u[p];
		}
		if(p%2==0){
			s-=t-r[p];
		}
		else{
			s+=t-r[p];
		}
		s=max(0,min(X,s));
		printf("%d\n",s);
	}




	return 0;
}

