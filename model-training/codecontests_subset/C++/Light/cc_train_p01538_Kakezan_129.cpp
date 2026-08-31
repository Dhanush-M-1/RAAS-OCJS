#include<stdio.h>
#include<algorithm>
using namespace std;
bool v[1000001];
int d[7];
int main(){
	int a;
	scanf("%d",&a);
	while(a--){
		for(int i=0;i<1000001;i++)v[i]=0;
		int ret=0;
		int b;
		scanf("%d",&b);
		while(1){
			v[b]=true;
			if(b<10)break;
			int c=b;
			int i=0;
			while(c){
				d[i++]=c%10;
				c/=10;
			}
			int to=0;
			for(int j=0;j<i-1;j++){
				int e=0;
				int f=0;
				for(int k=j;k>=0;k--){
					e*=10;
					e+=d[k];
				}
				for(int k=i-1;k>j;k--){
					f*=10;
					f+=d[k];
				}
				to=max(to,e*f);
			}
			if(v[to]){
				ret=-1;
				break;
			}
			b=to;
			ret++;
		}
		printf("%d\n",ret);
	}
}