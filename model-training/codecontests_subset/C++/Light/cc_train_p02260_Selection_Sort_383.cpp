#include<iostream>
#include<algorithm>
using namespace std;
int main(){
	int N,a[102];
	cin>>N;
	for(int i=0;i<N;i++)cin>>a[i];
	int minj,i,j,cnt=0;
	for(i=0;i<N;i++){
		minj=i;
		for(j=i;j<N;j++){
			if(a[minj]>a[j])minj=j;
		}
		if(minj!=i)cnt++;
		swap(a[minj],a[i]);
	}
	int first=1;
	for(i=0;i<N;i++){
		if(first)first=0;else cout<<" ";
		cout<<a[i];
	}
	cout<<endl<<cnt<<endl;
}
