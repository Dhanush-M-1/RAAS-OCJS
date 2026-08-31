#include <cstdio>
#include <cstring>
int q,n;
bool data[1000001];
int main(void){
	scanf("%d",&q);
	for(int i=0;i<q;i++){
		scanf("%d",&n);
		memset(data,false,sizeof(data));
		int x=n,next,cnt=0;
		while(1){
			if(data[x]){
				printf("-1\n");
				break;
			}
			if(x<=9){
				printf("%d\n",cnt);
				break;
			}
			data[x]=true;
			next=-1;
			int a=x,b=0,c=1;
			while(a>0){
				b=b+(a%10)*c;
				a/=10;
				if(a*b>next)next=a*b;
				c*=10;
			}
			x=next;
			cnt++;
		}
	}
	return 0;
}