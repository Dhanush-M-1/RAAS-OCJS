#include<algorithm>
#include<cstdio>
#include<cstring>
using namespace std;
int c[501],d[500][500][10][3][2],m;
bool e;
int fi(int p,int q,int r,int s,bool t){
	int i;
	if(p<0){
		if(t&&!q)
			e=true;
		return !q;
	}
	if(d[p][q][r][s][t?1:0]>=0)
		return d[p][q][r][s][t?1:0];
	int ct=0;
	if(s==0||s==2){
		for(i=r+1;i<=(t?c[p]:9);++i)
			ct=(ct+fi(p-1,(q*10+i)%m,i,1,t&&i==c[p]))%10000;
	}
	if(s==1||s==2){
		for(i=0;i<=min(t?c[p]:9,r-1);++i)
			ct=(ct+fi(p-1,(q*10+i)%m,i,0,t&&i==c[p]))%10000;
	}
	return d[p][q][r][s][t?1:0]=ct;
}
int main(){
	int i,j;
	char a[502],b[502];
	scanf("%s%s%d",a,b,&m);
	int aln=strlen(a),bln=strlen(b);
	int ct=0;
	memset(d,-1,sizeof(d));
	for(i=0;b[i];++i)
		c[bln-i-1]=b[i]-'0';
	for(i=aln;i<=bln;++i)
		for(j=1;j<=(i==bln?c[bln-1]:9);++j)
			ct=(ct+fi(i-2,j%m,j,2,i==bln&&j==c[bln-1]))%10000;
	memset(d,-1,sizeof(d));
	for(i=0;a[i];++i)
		c[aln-i-1]=a[i]-'0';
	e=false;
	for(j=1;j<=c[aln-1];++j)
		ct=(ct-fi(aln-2,j%m,j,2,j==c[aln-1])+10000)%10000;
	if(e)
		ct=(ct+1)%10000;
	printf("%d\n",ct);
	return 0;
}