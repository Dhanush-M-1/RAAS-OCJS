#include<bits/stdc++.h>
using namespace std;
int T,n,m,flag,k,a[110],b[110],ans[300];
int main()
{
	scanf("%d",&T);
	while (T--) {
		scanf("%d%d%d",&k,&n,&m);
		for (int i=1;i<=n;i++) scanf("%d",&a[i]);
		for (int i=1;i<=m;i++) scanf("%d",&b[i]);
		flag=1;
		for (int i=1,j=1;i<=n||j<=m;) {
			if ((a[i]>k||i>n)&&(b[j]>k||j>m)) {
				flag=0;
				break;
			}
			while (a[i]<=k&&i<=n) {
				ans[i+j-1]=a[i];
				if (a[i]==0) k++;
				i++;
			}
			while (b[j]<=k&&j<=m) {
				ans[i+j-1]=b[j];
				if (b[j]==0) k++;
				j++;
			}
		}
		if (flag) {
			for (int i=1;i<=n+m;i++) printf("%d ",ans[i]);
			printf("\n");
		} else {
			printf("-1\n");
		}
	}
	return 0;
}

