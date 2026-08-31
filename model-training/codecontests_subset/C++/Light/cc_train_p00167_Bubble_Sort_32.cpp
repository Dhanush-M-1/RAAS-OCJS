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

int n,a[100];

int main(){
	while(cin>>n){
		if(!n)return 0;
		int ans=0;
		for(int i=0;i<n;i++)cin>>a[i];
		for(int i=0;i<n-1;i++){
			for(int j=0;j<n-1-i;j++){
				if(a[j]>a[j+1]){
					ans++;
					swap(a[j],a[j+1]);
				}
			}
		}
		cout<<ans<<endl;
	}
}