#include<cstdio>
#include<algorithm>
#include<cstring>
using namespace std;
const int maxn=100010;
int n,m,a[maxn];
int calc(int l,int r,int x)
{return max(l,min(r,x));}
int main(){
	int X;
	scanf("%d%d",&X,&n);
	for(int i=1;i<=n;i++)scanf("%d",&a[i]);
	int L=0,R=X;//初值……习惯 
	int t=0,k=0,s=-1,x=0;
	int time,A;
	scanf("%d",&m);
	for(int i=1;i<=m;i++){
		scanf("%d%d",&time,&A);
		while(k<n&&a[k+1]<=time){
			int dif=s*(a[k+1]-t);
			L=calc(0,X,L+dif);
			R=calc(0,X,R+dif);
			s*=-1;
			x+=dif;
			t=a[k+1];
			k++;
		}//printf("\nL=%d R=%d\n",L,R);
		//printf("\nk=%d\n",k);
		int T=time-t;
		A=calc(L,R,A+x);
		//printf("\nA=%d\n",A);
		A=calc(0,X,A+s*T);
		printf("%d\n",A);
	}
	return 0;
}