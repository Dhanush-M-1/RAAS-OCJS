#include <bits/stdc++.h>
#define MOD 1000000007LL
using namespace std;

typedef long long ll;
typedef pair<int,int> P;

int n;
int cnt[101];
int cal[5]={5,7,5,7,7,};

int main(void){
	while(1){
		scanf("%d",&n);
		if(n==0)break;
		for(int i=0;i<n;i++){
			string str;
			cin >> str;
			cnt[i]=str.size();
		}
		int res=-1;
		for(int i=0;i<n;i++){
			if(res!=-1)continue;
			int now=0;
			int len=0;
			for(int j=i;j<n;j++){
				len+=cnt[j];
				if(len==cal[now]){
					now++;
					len=0;
				}else if(len>cal[now]){
					break;
				}
				if(now==5){
					res=i;
					break;
				}
			}
		}
		printf("%d\n",res+1);
	}
	return 0;
}