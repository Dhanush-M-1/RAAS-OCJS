# include <iostream>
using namespace std;
int main(void)
{
	int n,a[100],ans = 0;
	scanf("%d",&n);
	for(int i = 0;i < n;i++) scanf("%d",&a[i]);
	for(int i = 0;i < n-1;i++)
	{
		int index = i;
		for(int j = i+1;j < n;j++) if(a[j] < a[index]) index = j;
		if(index != i)
		{
			ans++;
			swap(a[i],a[index]); 
		}
	}
	for(int i = 0;i < n;i++) printf("%d%c",a[i],(i == n-1)?'\n':' ');
	printf("%d\n",ans);
	return 0;
}
