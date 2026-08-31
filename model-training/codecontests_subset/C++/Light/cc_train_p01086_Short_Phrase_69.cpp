/*** ?????\ ***/

#include <bits/stdc++.h>
using namespace std;
#define REP(i, a, n) for(int i=a; i<n; i++)

int main() {
	int N;
	while(cin>>N, N){
		int len[41]={};
		REP(i, 0, N){
			string s;
			cin >> s;
			len[i]=s.size();
		}
		
		REP(i, 0, N){
			int num=0;
			int haiku[5]={5, 7, 5, 7, 7};
			bool flag=false;
			
			REP(j, i, N){
				haiku[num]-=len[j];
				if(haiku[num]<0) break;
				if(haiku[num]==0) num++;
				if(num==5){
					flag=true;
					break;
				}
			}
			
			if(flag){
				cout << i+1 << endl;
				break;
			}
		}
	}
	return 0;
}