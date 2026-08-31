#include<iostream>
using namespace std;
void hoandoi(int &c,int &b)
{
	int t=c;c=b;b=t;
}


int main(){
	int n,*a,d=0,min;
	cin>>n;
	a=new int[n];
	for(int i=0;i<n;i++)
		cin>>a[i];
	for(int i=0;i<n-1;i++)
	{
		min=i;
		for(int j=i+1;j<n;j++){
			if(a[j]<a[min]){
				min=j;
			}
		}
		if(min!=i){
			hoandoi(a[i],a[min]);
			d++;}
	}
	for(int i=0;i<n;i++)
		{cout<<a[i];
		if(i<n-1)
			cout<<" ";
	}
	cout << endl << d << endl;

	return 0;
}