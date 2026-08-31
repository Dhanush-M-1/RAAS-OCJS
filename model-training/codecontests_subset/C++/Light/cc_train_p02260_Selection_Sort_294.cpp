#include<iostream>
#include<algorithm>
using namespace std;

int main(){
	int N,count=0;
	//??\???
	cin >> N;
	int A[N];
	for(int i=0;i<N;i++)
		cin >> A[i];
	//??卒???
	for(int i=0;i<N;i++){
		int mini = i,flag = 0;
		for(int j=i;j<N;j++)
			if(A[j]<A[mini]){
				mini = j;
				flag = 1;
			}
		if(flag){
			swap(A[i],A[mini]);
			count++;
		}
	}
	//??????
	for(int i=0;i<N;i++){
		if(i>0)	cout<< " ";
		cout<< A[i];
	}
	cout<< endl << count << endl;
	return 0;
}