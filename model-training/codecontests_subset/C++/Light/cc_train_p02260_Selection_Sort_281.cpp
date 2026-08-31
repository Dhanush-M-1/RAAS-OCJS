#include<iostream>
using namespace std;
const int MAXN=105;
int A[MAXN];

int main(){
	int n;
	cin>>n;
	for(int i=0;i<n;i++)cin>>A[i];
	int res=0;
	for(int i=0;i<n;i++){
		int minn=i;
		for(int j=i+1;j<n;j++){
			if(A[minn]>A[j]){
				minn=j;
			}
		}
		if(minn!=i){
			swap(A[minn],A[i]);
			res++;
		}
	}
	for(int i=0;i<n;i++){
		cout<<A[i];
		if(i!=n-1)cout<<" ";
	}
	cout<<endl<<res<<endl;
	return 0;
}
