#include <stdio.h>
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
int main(){
	while(1){
		int n; cin >> n;
		if(!n) return 0;
		vector<int>z;
		for(int i=0;i<n;i++){
			string a; cin >> a; z.push_back(a.size());
		}
		for(int i=0;i<n;i++){
			int cur = 0; int cnt = 0;
			for(int j=i;j<z.size();j++){
				cur += z[j];
				if(cur < 5) continue;
				if(cur > 7) goto fail;
				if(cur == 5 && (cnt==0||cnt==2)){
					cnt++; cur = 0;
				}
				else if(cur == 7 && (cnt==1||cnt==3||cnt==4)){
					cnt++; cur = 0;
				}
				if(cnt == 5){
					printf("%d\n",i+1); goto nxt;
				}
			}
		  fail:;
		}
	  nxt:;
	}
}