#include <iostream>
using namespace std;
#define MAX 100
void print(int A[],int n){
		for(int i=0;i<n;i++){
			if(i>0)
				cout<<" ";
			cout<<A[i];	
		}
		cout<<endl;	
}
int main(){
	int n,A[MAX],k=0,j,minj,temp;
	cin>>n;
	for(int i=0;i<n;i++)
		cin>>A[i];

	for(int i=0;i<n;i++){
		minj=i;
		for(j=i+1;j<n;j++){
			if(A[j]<A[minj]){
				minj=j;
			}
		}
		temp=A[minj];
		A[minj]=A[i];
		A[i]=temp;
		if(i!=minj)k++;
	}
	print(A,n);
	cout<<k<<endl;
	return 0;
}
