package per.owisho.learn.multithread.base.visibility;

import per.owisho.learn.multithread.tools.Tools;

public class ThreadStartVisibility {

	//�̼߳�Ĺ������
	static int data = 0;
	
	public static void main(String[] args) {
		Thread thread = new Thread(){
			@Override
			public void run(){
				//ʹ��ǰ�߳�����R���루R��ֵΪ�������
				Tools.randomPause(50);
				//��ȡ����ӡ����data��ֵ
				System.out.println(data);
			}
		};
		//�����߳�thread����ǰ���±���data��ֵ
		data = 1;
		thread.start();
		//ʹ��ǰ�߳�����R���루R��ֵΪα�������
		Tools.randomPause(50);
		//�����߳�thread��������±���data��ֵ
		data = 2;
	}
	
}
