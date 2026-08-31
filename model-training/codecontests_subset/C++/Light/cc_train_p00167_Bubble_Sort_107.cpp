#include <iostream>
#include <queue>
#include <stack>
#include <vector>
#include <stdio.h>
#include <algorithm>
#include <string.h>
#include <string>
#include <cmath>
#include <complex>
#include <map>
using namespace std;

#define rep(i,n) for(int i=0;i<int(n);++i)
#define ALL(v) (v).begin(),(v).end()
#define PB push_back
#define EPS 1e-8
#define F first
#define S second

static const double PI=6*asin(0.5);
typedef pair<double,double> P;
typedef complex<double> CP;
typedef long long ll;

int a[110];

int main(){
	int n;
	while(cin>>n,n){
		rep(i,110) a[i]=0;
		rep(i,n){
			cin>>a[i];
		}
		ll res=0;
		for(int i=n;i>1;i--){
			for(int j=0;j<i-1;j++){
				if(a[j]>a[j+1]){
					int t;
					t=a[j+1];
					a[j+1]=a[j];
					a[j]=t;
					res++;
				}
			}
		}
		cout<<res<<endl;
	}
	return 0;
}