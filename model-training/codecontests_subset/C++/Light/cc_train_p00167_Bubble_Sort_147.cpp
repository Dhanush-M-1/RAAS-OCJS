#include<iostream>

using namespace std;

int main()
{
	int n,i,j,ans,array[1000];
	
	for(;;)
	{
		cin >> n;
		if(n==0)
			break;
		ans=0;
		for(i=0;i<n;i++)
			cin >> array[i];
		
		for(;n>1;)
		{
			for(i=0;i<n-1;i++)
			{
				if(array[i]>array[i+1])
				{
					int a;
					a=array[i];
					array[i]=array[i+1];
					array[i+1]=a;
					ans++;
				}
			}
			n--;
		}
		cout << ans << endl;
	}
}