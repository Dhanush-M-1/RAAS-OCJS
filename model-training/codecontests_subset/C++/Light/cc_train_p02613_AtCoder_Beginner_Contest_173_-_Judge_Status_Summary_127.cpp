#include<bits/stdc++.h>
using namespace std;
int n;
int main()
{
	int ac=0,re=0,tle=0,wa=0,i;
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		char p[5];
		scanf("%s",p);
		if(p[0]=='A')ac++;
		if(p[0]=='T')tle++;
		if(p[0]=='W')wa++;
		if(p[0]=='R')re++;
	}
	printf("AC x %d\nWA x %d\nTLE x %d\nRE x %d",ac,wa,tle,re);
}