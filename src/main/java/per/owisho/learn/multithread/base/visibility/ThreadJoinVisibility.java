package per.owisho.learn.multithread.base.visibility;

import per.owisho.learn.multithread.tools.Tools;

public class ThreadJoinVisibility {

	//�̼߳�Ĺ������
	static int data = 0;
	
	public static void main(String[] args) {
		
		Thread thread = new Thread(){
			@Override
			public void run(){
				//ʹ��ǰ�߳�����R���루R��ֵΪ�������
				Tools.randomPause(50);
				//����data��ֵ
				data = 1;
			}
		};
		
		thread.start();
		
		//�ȴ��߳�thread������main�̲߳��ܼ�������
		try{
			thread.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		//��ȡ����ӡ����data��ֵ
		System.out.println(data);
	}
	
}
