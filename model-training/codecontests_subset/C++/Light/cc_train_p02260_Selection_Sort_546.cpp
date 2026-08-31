# include <stdio.h>
int main()
{
	int a[100];
	int n;
	int num = 0;
	
	scanf("%d",&n);
	for(int i = 0; i < n; ++i)		scanf("%d", &a[i]);
	for (int i = 0; i < n; i++)
	{
		int tem = i;
		for (int j = i + 1; j < n; j++)
		{
			if (a[tem] > a[j])	tem = j;
		}
		if (tem != i)
		{
		int v = a[tem];
		a[tem] = a[i];
		a[i] = v;
		++num;
		}
	}
	for(int i = 0; i < n - 1; ++i)
	{
		printf("%d ", a[i]);
	}
	printf("%d\n%d\n", a[n-1],num);
 } 
