#include <iostream>
#include <cstring>
using namespace std;
int main()
{
	int i,j,k,n,m;
	int a[105];
	while(cin>>n)
	{
		for(i=0;i<n;i++)
			cin>>a[i];
		m=0;
		for(i=0;i<n-1;i++)
		{
			k=i;
			for(j=i+1;j<n;j++)
				if(a[j]<a[k])
					k=j;
			if(k!=i)
			{
				swap(a[k],a[i]);
				m++;
			}
		}
		for(i=0;i<n-1;i++)
			cout<<a[i]<<" ";
		cout<<a[n-1]<<endl<<m<<endl;
	}	
}
