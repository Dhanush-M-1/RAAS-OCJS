#include <cstdio>

char pi[2333];

void sou(int n,int k,int p)
{
	if(n==0)
	{
		printf("%s",pi); return;
	}
	for(int i=0; i<p; i++)
	{
		pi[k]='a'+i;
		sou(n-1,k+1,p);
	}
	if(p!=26)
	{
		pi[k]='a'+p;
		sou(n-1,k+1,p+1);
	}
	return;
}

int main()
{
	int n; scanf("%d",&n);
	pi[n]='\n'; pi[n+1]='\0';
	sou(n,0,0);
	return 0;
}