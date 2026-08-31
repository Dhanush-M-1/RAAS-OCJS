#include <cstdio>

using namespace std;

int main()
{
	double xs[4],ys[4],a,t;
	int p,np,ans;
	while(scanf("%lf,%lf,%lf,%lf,%lf,%lf,%lf,%lf",&xs[0],&ys[0],&xs[1],&ys[1],&xs[2],&ys[2],&xs[3],&ys[3])!=EOF){
		ans=a=t=0;
		for(int i=0;i<4;i++){
			p=(i+3)%4;
			np=(i+1)%4;
			t=(xs[i]-xs[p])*(ys[np]-ys[i])-(ys[i]-ys[p])*(xs[np]-xs[i]);
			if(a*t<0){
				ans=1;
				break;
			}
			else{
				a=t;
			}
		}
		if(ans==0){
			printf("YES\n");
		}
		else{
			printf("NO\n");
		}
	}
	return 0;
}