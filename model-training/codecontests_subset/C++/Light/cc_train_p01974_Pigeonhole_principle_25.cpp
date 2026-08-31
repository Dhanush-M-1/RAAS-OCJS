#include <bits/stdc++.h>
#define MOD 1000000007LL
using namespace std;
typedef long long ll;
typedef pair<int,int> P;

int n;
int a[1001];

int main(void){
	scanf("%d",&n);
	for(int i=0;i<n;i++){
		scanf("%d",&a[i]);
	}
	for(int i=0;i<n;i++){
		for(int j=i+1;j<n;j++){
			int di=abs(a[i]-a[j]);
			if(di%(n-1)==0){
				printf("%d %d\n",a[i],a[j]);
				return 0;
			}
		}
	}
	return 0;
}
